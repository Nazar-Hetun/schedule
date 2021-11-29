package elinext.schedule.dto.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class StudentRequestDto {
    private String name;
    private LocalDate localDate;
}
