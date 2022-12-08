package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
//class AppTest {
//    @Test
//    void testApp() {
//        String[][] image = {
//                {"*", "*", "*", "*"},
//                {"*", " ", " ", "*"},
//                {"*", " ", " ", "*"},
//                {"*", "*", "*", "*"},
//        };
//        String[][] imageExpected = {
//                {"*", "*", "*", "*", "*", "*", "*", "*"},
//                {"*", "*", "*", "*", "*", "*", "*", "*"},
//                {"*", "*", " ", " ", " ", " ", "*", "*"},
//                {"*", "*", " ", " ", " ", " ", "*", "*"},
//                {"*", "*", " ", " ", " ", " ", "*", "*"},
//                {"*", "*", " ", " ", " ", " ", "*", "*"},
//                {"*", "*", "*", "*", "*", "*", "*", "*"},
//                {"*", "*", "*", "*", "*", "*", "*", "*"},
//        };
//        String[][] actual = App.enlargeArrayImage(image);
//        assertThat(actual).isEqualTo(imageExpected);
//
//    }
//}
// END
