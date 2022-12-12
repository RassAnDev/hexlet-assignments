package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> firstData, Map<String, Object> secondData) {
        Map<String, String> result = new LinkedHashMap<>();

        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(firstData.keySet());
        allKeys.addAll(secondData.keySet());

        for (String key : allKeys) {
            if (!(firstData.containsKey(key))) {
                result.put(key, "added");
            } else if (firstData.containsKey(key) && !(secondData.containsKey(key))) {
                result.put(key, "deleted");
            } else if (firstData.containsKey(key) && secondData.containsKey(key)
                    && !firstData.get(key).equals(secondData.get(key))) {
                result.put(key, "changed");
            } else {
                result.put(key, "unchanged");
            }
        }
        return result;
    }
}
//END
