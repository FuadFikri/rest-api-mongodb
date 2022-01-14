package id.fikri.syamsudin.restapimongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Address address;

    @Indexed(unique = true)
    private String email;
    private List<String> favouriteSubjects;
    private LocalDateTime createdAt;
}
