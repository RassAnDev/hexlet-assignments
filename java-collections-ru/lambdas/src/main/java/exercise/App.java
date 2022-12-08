package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] images) {
        return Arrays.stream(images)
                .flatMap(image -> Arrays.stream(image))
                .map(item -> new String[] {item, item})
                .toArray(String[][]::new);
    }
}
// END
