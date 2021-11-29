package elinext.schedule.dto.response;

import java.util.List;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
public class GroupResponseDto {
    private Long id;
    private String name;
    @OneToMany
    private List<ClassResponseDto> classes;
}
