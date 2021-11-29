package elinext.schedule.service.impl;

import elinext.schedule.exception.DataProcessingException;
import elinext.schedule.model.Class;
import elinext.schedule.repository.ClassRepository;
import elinext.schedule.service.ClassService;
import java.time.DayOfWeek;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {
    private ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Class add(Class clazz) {
        return classRepository.save(clazz);
    }

    @Override
    public Class get(Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new DataProcessingException("Can't find class by id " + id));
    }

    @Override
    public List<Class> getAll() {
        return classRepository.getAll();
    }

    @Override
    public List<Class> getAllByDayOfWeek(DayOfWeek dayOfWeek) {
        return classRepository.getAllByDayOfWeek(dayOfWeek);
    }

    @Override
    public Class update(Class clazz) {
        return classRepository.save(clazz);
    }

    @Override
    public void delete(Class clazz) {
        classRepository.delete(clazz);
    }
}
