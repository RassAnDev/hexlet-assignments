package exercise;


import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static KeyValueStorage swapKeyValue(KeyValueStorage dataBase) {
        Map<String, String> storage = dataBase.toMap();

        for (Map.Entry<String, String> keyValue : storage.entrySet()) {
            String newKey = keyValue.getValue();
            String newValue = keyValue.getKey();
            dataBase.set(newKey, newValue);
            dataBase.unset(newValue);
        }
        return dataBase;
    }
}
// END
