package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public static Car unserialize(String jsonToUnserialize) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonToUnserialize, Car.class);
    }
    // END
}
