package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path pathToFile, Car instanceForSave) throws IOException {
        String inst = instanceForSave.serialize();
        System.out.println(inst);
        Files.writeString(pathToFile, instanceForSave.serialize(), StandardOpenOption.CREATE);
    }

    public static Car extract(Path pathToFile) throws IOException {
        String jsonRepresentation = Files.readString(pathToFile);
        return Car.unserialize(jsonRepresentation);
    }
}
// END
