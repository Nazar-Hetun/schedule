package elinext.schedule.mapper;

import elinext.schedule.dto.response.ClassResponseDto;
import elinext.schedule.model.Class;
import org.springframework.stereotype.Component;

@Component
public class ClassMapper implements ResponseDtoMapper<ClassResponseDto, Class> {
    private ClassroomMapper classroomMapper;

    public ClassMapper(ClassroomMapper classroomMapper) {
        this.classroomMapper = classroomMapper;
    }

    @Override
    public ClassResponseDto mapToDto(Class clazz) {
        ClassResponseDto classResponseDto = new ClassResponseDto();
        classResponseDto.setClassroom(classroomMapper.mapToDto(clazz.getClassroom()));
        classResponseDto.setId(clazz.getId());
        classResponseDto.setSubject(classResponseDto.getSubject());
        return classResponseDto;
    }
}
