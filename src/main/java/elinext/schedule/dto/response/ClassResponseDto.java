package elinext.schedule.dto.response;

import lombok.Data;

@Data
public class ClassResponseDto {
    private Long id;
    private String subject;
    private ClassroomResponseDto classroom;
}
