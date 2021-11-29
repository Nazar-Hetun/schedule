package elinext.schedule.mapper;

import elinext.schedule.dto.response.GroupResponseDto;
import elinext.schedule.model.Group;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper implements ResponseDtoMapper<GroupResponseDto, Group> {
    private ClassMapper classMapper;

    public GroupMapper(ClassMapper classMapper) {
        this.classMapper = classMapper;
    }

    @Override
    public GroupResponseDto mapToDto(Group group) {
        GroupResponseDto groupResponseDto = new GroupResponseDto();
        groupResponseDto.setId(group.getId());
        groupResponseDto.setClasses(group.getClasses().stream()
                .map(c -> classMapper.mapToDto(c))
                .collect(Collectors.toList()));
        groupResponseDto.setName(groupResponseDto.getName());
        return groupResponseDto;
    }
}
