package elinext.schedule.mapper;

import static org.mockito.ArgumentMatchers.any;

import elinext.schedule.dto.response.ClassResponseDto;
import elinext.schedule.dto.response.ClassroomResponseDto;
import elinext.schedule.model.Class;
import java.time.DayOfWeek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClassMapperTest {
    private static final Integer ROOM_NUMBER = 404;
    private static final Integer EDUCATIONAL_BUILDING_NUMBER = 3;
    private static final Long CLASSROOM_ID = 22L;
    private static final Long ID = 2L;
    private static final String SUBJECT = "Math";
    private ClassroomMapper classroomMapper;
    private ClassMapper classMapper;

    @BeforeEach
    void setUp() {
        classroomMapper = Mockito.mock(ClassroomMapper.class);
        classMapper = new ClassMapper(classroomMapper);
    }

    @Test
    void mappingFromModelToDto_Ok() {
        Class clazz = new Class();
        clazz.setId(ID);
        clazz.setSubject(SUBJECT);
        clazz.setDayOfWeek(DayOfWeek.MONDAY);

        ClassroomResponseDto classroomResponseDto = new ClassroomResponseDto();
        classroomResponseDto.setRoomNumber(ROOM_NUMBER);
        classroomResponseDto.setEducationalBuildingNumber(EDUCATIONAL_BUILDING_NUMBER);
        classroomResponseDto.setId(CLASSROOM_ID);

        Mockito.when(classroomMapper.mapToDto(any())).thenReturn(classroomResponseDto);

        ClassResponseDto actual = classMapper.mapToDto(clazz);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual.getId(), ID);
        Assertions.assertEquals(actual.getSubject(), SUBJECT);
        Assertions.assertEquals(actual.getClassroom(), classroomResponseDto);
    }
}