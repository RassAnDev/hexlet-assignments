package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> actual = new ArrayList<>(Arrays.asList(1, 2));
        assertThat(App.take(list, 2)).isEqualTo(actual);
        // END
    }
}
