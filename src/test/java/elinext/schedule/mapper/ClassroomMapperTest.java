package elinext.schedule.mapper;

import elinext.schedule.dto.response.ClassroomResponseDto;
import elinext.schedule.model.Classroom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassroomMapperTest {
    private static final Integer ROOM_NUMBER = 404;
    private static final Integer EDUCATIONAL_BUILDING_NUMBER = 3;
    private static final Long ID = 22L;
    private ClassroomMapper classroomMapper;

    @BeforeEach
    void setUp() {
        classroomMapper = new ClassroomMapper();
    }

    @Test
    void mappingFromModelToDto_Ok() {
        Classroom classroom = new Classroom();
        classroom.setRoomNumber(ROOM_NUMBER);
        classroom.setEducationalBuildingNumber(EDUCATIONAL_BUILDING_NUMBER);
        classroom.setId(ID);

        ClassroomResponseDto actual = classroomMapper.mapToDto(classroom);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual.getId(), ID);
        Assertions.assertEquals(actual.getRoomNumber(), ROOM_NUMBER);
        Assertions.assertEquals(actual.getEducationalBuildingNumber(),
                EDUCATIONAL_BUILDING_NUMBER);
    }
}