package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> dataMap;

    public InMemoryKV() {

    }

    public InMemoryKV(Map<String, String> map) {
        this.dataMap = new HashMap<>(map);
    }

    public void set(String key, String value) {
        this.dataMap.put(key, value);
    }

    public void unset(String key) {
        this.dataMap.remove(key);
    }

    public String get(String key, String defaultValue) {
        return this.dataMap.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        return new HashMap<>(this.dataMap);
    }
}
// END
