package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int apartmentAmount) {
        return apartments.stream()
                .sorted((n, m) -> n.compareTo(m))
                .limit(apartmentAmount)
                .map(n -> n.toString())
                .collect(Collectors.toList());
    }
}
// END
