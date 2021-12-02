package elinext.schedule.repository;

import elinext.schedule.model.StudentGroup;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {
    @Query("SELECT g FROM StudentGroup g "
            + " LEFT JOIN FETCH g.classes c"
            + " LEFT JOIN FETCH c.classroom "
            + " WHERE g.id = ?1 AND c.dayOfWeek = ?2 ")
    Optional<StudentGroup> findByIdAndDayOfWeek(Long id, DayOfWeek dayOfWeek);

    @Override
    Optional<StudentGroup> findById(Long id);

    @Query("select g from StudentGroup g")
    List<StudentGroup> getAll();
}
