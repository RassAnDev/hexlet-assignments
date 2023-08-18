package exercise.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Entity
// END
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // BEGIN
    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }
    // END
}
