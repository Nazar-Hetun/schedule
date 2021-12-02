package elinext.schedule.service;

import elinext.schedule.model.StudentGroup;
import java.time.DayOfWeek;
import java.util.List;

public interface StudentGroupService {
    StudentGroup add(StudentGroup studentGroup);

    StudentGroup get(Long id);

    StudentGroup findByIdAndDayOfWeek(Long id, DayOfWeek dayOfWeek);

    List<StudentGroup> getAll();

    StudentGroup update(StudentGroup studentGroup);

    void delete(StudentGroup studentGroup);
}
