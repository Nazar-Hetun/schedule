package elinext.schedule.service;

import elinext.schedule.model.Class;
import java.time.DayOfWeek;
import java.util.List;

public interface ClassService {
    Class add(Class clazz);

    Class get(Long id);

    List<Class> getAll();

    List<Class> getAllByDayOfWeek(DayOfWeek dayOfWeek);

    Class update(Class clazz);

    void delete(Class clazz);
}
