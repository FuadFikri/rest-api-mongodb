package id.fikri.syamsudin.restapimongodb.repository;

import id.fikri.syamsudin.restapimongodb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findByEmail(String email);
}
