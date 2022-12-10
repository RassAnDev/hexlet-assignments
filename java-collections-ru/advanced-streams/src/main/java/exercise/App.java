package exercise;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String confFile) {
        return Stream.of(confFile.split("\n"))
                .filter(str -> str.startsWith("environment"))
                .map(str -> str.replaceAll("environment=", ""))
                .map(str -> str.replaceAll("\"", ""))
                .flatMap(str -> Stream.of(str.split(",")))
                .filter(str -> str.startsWith("X_FORWARDED_"))
                .map(str -> str.trim().replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
