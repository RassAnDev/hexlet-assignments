package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;


// BEGIN
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testSaveStorage() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        assertThat(FileKV.saveStorage(storage.toMap())).isEqualTo("{\"key\":\"value\"}");
    }

    @Test
    public void testGetStorage() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        String content = FileKV.saveStorage(storage.toMap());
        assertThat(FileKV.getStorage(content)).isEqualTo(Map.of("key", "value"));
    }
    // END
}
