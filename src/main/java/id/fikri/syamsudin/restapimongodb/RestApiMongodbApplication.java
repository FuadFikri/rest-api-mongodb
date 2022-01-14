package id.fikri.syamsudin.restapimongodb;

import id.fikri.syamsudin.restapimongodb.model.Address;
import id.fikri.syamsudin.restapimongodb.model.Gender;
import id.fikri.syamsudin.restapimongodb.model.Student;
import id.fikri.syamsudin.restapimongodb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class RestApiMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiMongodbApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address();
            address.setCode("PO90");
            address.setCountry("USA");
            address.setStreet("kamb street");

            Student student = new Student();
            student.setFirstName("Fikri");
            student.setLastName("Fuad");
            student.setGender(Gender.MALE);
            student.setEmail("fikri@mail.com");
            student.setAddress(address);
            student.setFavouriteSubjects(List.of("Math", "Algorithm", "Art"));
            student.setCreatedAt(LocalDateTime.now());

            Query query = new Query();
            query.addCriteria(Criteria.where("email").is("fikri@mail.com"));
            List<Student> students =  mongoTemplate.find(query,Student.class);

            if (!students.isEmpty()){
                System.out.println("email used");
                throw new IllegalStateException("email used");
            }

            studentRepository.save(student);
        };

    }
}
