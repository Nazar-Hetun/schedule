package elinext.schedule.mapper;

import elinext.schedule.dto.response.ClassroomResponseDto;
import elinext.schedule.model.Classroom;
import org.springframework.stereotype.Component;

@Component
public class ClassroomMapper implements ResponseDtoMapper<ClassroomResponseDto, Classroom> {
    @Override
    public ClassroomResponseDto mapToDto(Classroom classroom) {
        ClassroomResponseDto classroomResponseDto = new ClassroomResponseDto();
        classroomResponseDto.setId(classroom.getId());
        classroomResponseDto.setRoomNumber(classroom.getRoomNumber());
        classroomResponseDto.setEducationalBuildingNumber(classroom.getEducationalBuildingNumber());
        return classroomResponseDto;
    }
}
