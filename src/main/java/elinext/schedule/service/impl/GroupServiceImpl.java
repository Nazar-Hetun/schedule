package elinext.schedule.service.impl;

import elinext.schedule.exception.DataProcessingException;
import elinext.schedule.model.StudentGroup;
import elinext.schedule.repository.StudentGroupRepository;
import elinext.schedule.service.StudentGroupService;
import java.time.DayOfWeek;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements StudentGroupService {
    private StudentGroupRepository studentGroupRepository;

    public GroupServiceImpl(StudentGroupRepository studentGroupRepository) {
        this.studentGroupRepository = studentGroupRepository;
    }

    @Override
    public StudentGroup add(StudentGroup studentGroup) {
        return studentGroupRepository.save(studentGroup);
    }

    @Override
    public StudentGroup get(Long id) {
        return studentGroupRepository.findById(id)
                .orElseThrow(() -> new DataProcessingException("Can't find group by id " + id));
    }

    @Override
    public StudentGroup findByIdAndDayOfWeek(Long id, DayOfWeek dayOfWeek) {
        return studentGroupRepository.findByIdAndDayOfWeek(id, dayOfWeek).orElseThrow(
                () -> new DataProcessingException("Can't find classes for day " + dayOfWeek));
    }

    @Override
    public List<StudentGroup> getAll() {
        return studentGroupRepository.getAll();
    }

    @Override
    public StudentGroup update(StudentGroup studentGroup) {
        return studentGroupRepository.save(studentGroup);
    }

    @Override
    public void delete(StudentGroup studentGroup) {
        studentGroupRepository.delete(studentGroup);
    }

}
