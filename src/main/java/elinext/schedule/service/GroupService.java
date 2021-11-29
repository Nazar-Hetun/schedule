package elinext.schedule.service;

import elinext.schedule.model.Group;
import java.time.DayOfWeek;
import java.util.List;

public interface GroupService {
    Group add(Group group);

    Group get(Long id);

    Group findByIdAndDayOfWeek(Long id, DayOfWeek dayOfWeek);

    List<Group> getAll();

    Group update(Group group);

    void delete(Group group);
}
