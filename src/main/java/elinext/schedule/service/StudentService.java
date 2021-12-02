package elinext.schedule.service;

import elinext.schedule.model.Student;
import java.util.List;

public interface StudentService {
    Student add(Student student);

    Student get(Long id);

    List<Student> getAll();

    Student getByName(String name);

    Student update(Student student);

    void delete(Student student);
}
