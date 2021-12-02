package elinext.schedule.service.impl;

import elinext.schedule.exception.DataProcessingException;
import elinext.schedule.model.Student;
import elinext.schedule.repository.StudentRepository;
import elinext.schedule.service.StudentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student add(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student get(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student getByName(String name) {
        return studentRepository.findByName(name).orElseThrow(
                () -> new DataProcessingException("Can't find student with this name " + name));
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
