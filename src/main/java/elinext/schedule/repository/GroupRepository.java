package elinext.schedule.repository;

import elinext.schedule.model.Group;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("SELECT g FROM Group g " +
            " LEFT JOIN FETCH g.classes c" +
            " LEFT JOIN FETCH c.classroom cl" +
            " WHERE g.id = ?1 AND c.dayOfWeek = ?2 ")
    Optional<Group> findByIdAndDayOfWeek(Long id, DayOfWeek dayOfWeek);

    Optional<Group> findById(Long id);

    @Query("select g from Group g")
    List<Group> getAll();
}
