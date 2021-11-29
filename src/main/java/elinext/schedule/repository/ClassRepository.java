package elinext.schedule.repository;

import elinext.schedule.model.Class;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassRepository extends JpaRepository<Class, Long> {

    @Override
    Optional<Class> findById(Long id);

    @Query("select c from Class c")
    List<Class> getAll();

    @Query("select c from Class c WHERE c.dayOfWeek = ?1")
    List<Class> getAllByDayOfWeek(DayOfWeek dayOfWeek);
}
