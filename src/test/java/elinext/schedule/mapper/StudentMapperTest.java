package elinext.schedule.mapper;

import elinext.schedule.dto.response.StudentResponseDto;
import elinext.schedule.model.Student;
import elinext.schedule.model.StudentGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentMapperTest {
    private static final Long STUDENT_GROUP_ID = 2L;
    private static final String STUDENT_GROUP_NAME = "DE-51";
    private static final Long ID = 3L;
    private static final String NAME = "Nazar";
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    void mappingFromModelToDto_Ok() {
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setId(STUDENT_GROUP_ID);
        studentGroup.setName(STUDENT_GROUP_NAME);

        Student student = new Student();
        student.setId(ID);
        student.setName(NAME);
        student.setStudentGroup(studentGroup);

        StudentResponseDto actual = studentMapper.mapToDto(student);
        Assertions.assertNotNull(student);
        Assertions.assertEquals(actual.getId(), ID);
        Assertions.assertEquals(actual.getName(), NAME);
        Assertions.assertEquals(actual.getGroupId(), STUDENT_GROUP_ID);
    }

}