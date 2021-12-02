package elinext.schedule.mapper;

import elinext.schedule.dto.response.StudentResponseDto;
import elinext.schedule.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements ResponseDtoMapper<StudentResponseDto, Student> {

    @Override
    public StudentResponseDto mapToDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setGroupId(student.getStudentGroup().getId());
        return studentResponseDto;
    }
}
