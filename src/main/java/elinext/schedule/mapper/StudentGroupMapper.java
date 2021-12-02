package elinext.schedule.mapper;

import elinext.schedule.dto.response.StudentGroupResponseDto;
import elinext.schedule.model.StudentGroup;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class StudentGroupMapper implements
        ResponseDtoMapper<StudentGroupResponseDto, StudentGroup> {
    private ClassMapper classMapper;

    public StudentGroupMapper(ClassMapper classMapper) {
        this.classMapper = classMapper;
    }

    @Override
    public StudentGroupResponseDto mapToDto(StudentGroup studentGroup) {
        StudentGroupResponseDto groupResponseDto = new StudentGroupResponseDto();
        groupResponseDto.setId(studentGroup.getId());
        groupResponseDto.setClasses(studentGroup.getClasses().stream()
                .map(c -> classMapper.mapToDto(c))
                .collect(Collectors.toList()));
        groupResponseDto.setName(studentGroup.getName());
        return groupResponseDto;
    }
}
