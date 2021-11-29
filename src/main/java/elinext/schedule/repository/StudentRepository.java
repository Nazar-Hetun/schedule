package elinext.schedule.repository;

import elinext.schedule.model.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByName(String name);

    @Override
    Optional<Student> findById(Long id);

    @Query("select s from Student s")
    List<Student> getAll();
}
