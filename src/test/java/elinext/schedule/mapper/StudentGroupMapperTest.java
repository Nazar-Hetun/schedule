package elinext.schedule.mapper;

import static org.mockito.ArgumentMatchers.any;

import elinext.schedule.dto.response.ClassResponseDto;
import elinext.schedule.dto.response.StudentGroupResponseDto;
import elinext.schedule.model.Class;
import elinext.schedule.model.StudentGroup;
import java.time.DayOfWeek;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StudentGroupMapperTest {
    private static final Long ID = 2L;
    private static final String STUDENT_GROUP_NAME = "DE-51";
    private static final Long CLASS_ID = 2L;
    private static final String SUBJECT = "Math";
    private StudentGroupMapper studentGroupMapper;
    private ClassMapper classMapper;

    @BeforeEach
    void setUp() {
        classMapper = Mockito.mock(ClassMapper.class);
        studentGroupMapper = new StudentGroupMapper(classMapper);
    }

    @Test
    void mappingFromModelToDto_Ok() {
        Class clazz = new Class();
        clazz.setId(CLASS_ID);
        clazz.setSubject(SUBJECT);
        clazz.setDayOfWeek(DayOfWeek.MONDAY);

        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setId(ID);
        studentGroup.setName(STUDENT_GROUP_NAME);
        studentGroup.setClasses(List.of(clazz));

        ClassResponseDto classResponseDto = new ClassResponseDto();
        classResponseDto.setId(CLASS_ID);
        classResponseDto.setSubject(SUBJECT);
        List<ClassResponseDto> classes = List.of(classResponseDto);

        Mockito.when(classMapper.mapToDto(any())).thenReturn(classResponseDto);

        StudentGroupResponseDto actual = studentGroupMapper.mapToDto(studentGroup);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual.getId(), ID);
        Assertions.assertEquals(actual.getName(), STUDENT_GROUP_NAME);
        Assertions.assertEquals(actual.getClasses(), classes);
    }
}