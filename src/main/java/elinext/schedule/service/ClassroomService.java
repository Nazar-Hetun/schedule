package elinext.schedule.service;

import elinext.schedule.model.Classroom;
import java.util.List;

public interface ClassroomService {
     Classroom add(Classroom classroom);

     Classroom get(Long id);

     List<Classroom> getAll();

     Classroom update(Classroom classroom);

     void delete(Classroom classroom);
}
