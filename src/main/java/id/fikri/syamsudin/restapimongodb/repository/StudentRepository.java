package id.fikri.syamsudin.restapimongodb.repository;

import id.fikri.syamsudin.restapimongodb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
