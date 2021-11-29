package elinext.schedule.service.impl;

import elinext.schedule.exception.DataProcessingException;
import elinext.schedule.model.Classroom;
import elinext.schedule.repository.ClassroomRepository;
import elinext.schedule.service.ClassroomService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Classroom add(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom get(Long id) {
        return classroomRepository.findById(id).orElseThrow(
                () -> new DataProcessingException("Can't find classroom by id " + id));
    }

    @Override
    public List<Classroom> getAll() {
        return classroomRepository.getAll();
    }

    @Override
    public Classroom update(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public void delete(Classroom classroom) {
        classroomRepository.delete(classroom);
    }
}
