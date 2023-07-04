package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        Path filePath = Paths.get("src/main/resources/users.json").toAbsolutePath().normalize();
        String dataFromFile = Files.readString(filePath);
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(dataFromFile, new TypeReference<List<Map>>() {});
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        List<Map> users = getUsers();
        response.setContentType("text/html;charset=UTF-8");

        String body = """
                <!DOCTYPE html>
                <html lang="ru">
                    <head>
                        <meta charset=UTF-8>
                        <title>HTML Homework</title>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                        rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                        crossorigin="anonymous">
                    </head>
                    <body>
                        <table>
                """;

        for (Map user : users) {
            body += "\n" + "<tr>" + "<td>" + user.get("id") + "</td>" + "\n"
            + "<td>" + "\n" + " " + "<a href=\"/users/" + user.get("id") + "\">" + user.get("firstName") + " "
                    + user.get("lastName") + "</a>" + "\n" + "</td>" + "\n" + "</tr>" + "\n";
        }

        body += """
                </table>
                </body>
                </html>""";

        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        out.println(body);
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        List<Map> users = getUsers();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String body = """
                <!DOCTYPE html>
                <html lang="ru">
                    <head>
                        <meta charset=UTF-8>
                        <title>HTML Homework</title>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                        rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                        crossorigin="anonymous">
                    </head>
                    <body>
                        <table>
                """;

        Map user = users.stream()
                .filter(u -> u.get("id").equals(id))
                .findAny()
                .orElse(null);

        if (user != null) {
            body += "\n" + "<tr>" + "<td>" + user.get("id") + "</td>" + "\n"
                    + "<td>" + "\n" + " " + user.get("firstName") + " " + user.get("lastName")
                    + " "  + user.get("email")+ "\n" + "</td>" + "\n" + "</tr>" + "\n";
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

        body += """
                </table>
                </body>
                </html>""";

        out.println(body);
        // END
    }
}
