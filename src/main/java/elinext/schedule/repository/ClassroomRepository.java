package elinext.schedule.repository;

import elinext.schedule.model.Classroom;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    @Override
    Optional<Classroom> findById(Long id);

    @Query("SELECT c FROM Classroom c")
    List<Classroom> getAll();
}
