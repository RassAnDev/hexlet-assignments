package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static String[] duplicateValues(String[] items) {
        return Arrays.stream(items)
                .flatMap(item -> Arrays.stream(new String[] {item, item}))
                .toArray(item -> new String[item]);
    }
    public static String[][] enlargeArrayImage(String[][] images) {
        String[][] horizontalStretched = Arrays.stream(images)
                .map(image -> App.duplicateValues(image))
                .toArray(image -> new String[image][]);

        return Arrays.stream(horizontalStretched)
                .flatMap(item -> Arrays.stream(new String[][]{item, item}))
                .toArray(item -> new String[item][]);
    }
}
// END
