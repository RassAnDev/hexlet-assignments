package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    String path;
    Map<String, String> storage;

    public FileKV(String path, Map<String, String> dataMap) {
        this.path = path;
        this.storage = new HashMap<>(dataMap);
    }

    public static String saveStorage(Map<String, String> dataMap) {
        return Utils.serialize(dataMap);
    }

    public static Map<String, String> getStorage(String content) {
        return Utils.unserialize(content);
    }
    @Override
    public void set(String key, String value) {
        this.storage.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.storage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(this.storage);
    }
}
// END
