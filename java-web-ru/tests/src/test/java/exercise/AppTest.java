package exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import io.javalin.Javalin;
import io.ebean.DB;

import exercise.domain.User;
import exercise.domain.query.QUser;
import io.ebean.Database;

class AppTest {

    private static Javalin app;
    private static String baseUrl;

    // BEGIN
    @BeforeAll
    public static void beforeAll() {
        app = App.getApp();
        app.start();
        int port = app.port();
        baseUrl = "http://localhost:" + port;
    }

    @AfterAll
    public static void afterAll() {
        app.stop();
    }
    // END

    // Между тестами база данных очищается
    // Благодаря этому тесты не влияют друг на друга
    @BeforeEach
    void beforeEach() {
        Database db = DB.getDefault();
        db.truncate("users");
        User existingUser = new User("Wendell", "Legros", "a@a.com", "123456");
        existingUser.save();
    }

    @Test
    void testUsers() {

        // Выполняем GET запрос на адрес http://localhost:port/users
        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users")
            .asString();
        // Получаем тело ответа
        String content = response.getBody();

        // Проверяем код ответа
        assertThat(response.getStatus()).isEqualTo(200);
        // Проверяем, что страница содержит определенный текст
        assertThat(response.getBody()).contains("Wendell Legros");
    }

    @Test
    void testNewUser() {

        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users/new")
            .asString();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    // BEGIN
    @Test
    void testCreateUserPositive() {
        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "Dead")
                .field("lastName", "Pool")
                .field("email", "dead@pool.com")
                .field("password", "deadpool")
                .asString();

        assertThat(responsePost.getStatus()).isEqualTo(302);

        User user = new QUser()
                .firstName.equalTo("Dead")
                .findOne();

        assertThat(user).isNotNull();
        assertThat(user.getFirstName()).isEqualTo("Dead");
        assertThat(user.getLastName()).isEqualTo("Pool");
        assertThat(user.getEmail()).isEqualTo("dead@pool.com");
        assertThat(user.getPassword()).isEqualTo("deadpool");
    }

    @Test
    void testCreateUserNegative() {
        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "")
                .field("lastName", "")
                .field("email", "dead@pool")
                .field("password", "dp")
                .asString();

        assertThat(responsePost.getStatus()).isEqualTo(422);

        User invalidUser = new QUser()
                .password.equalTo("dp")
                .findOne();

        assertThat(invalidUser).isNull();

        String body = responsePost.getBody();

        assertThat(body).contains("");
        assertThat(body).contains("Имя не должно быть пустым");
        assertThat(body).contains("Фамилия не должна быть пустой");
        assertThat(body).contains("Должно быть валидным email");
        assertThat(body).contains("dead@pool");
        assertThat(body).contains("Пароль должен содержать не менее 4 символов");
        assertThat(body).contains("dp");
    }
    // END
}
