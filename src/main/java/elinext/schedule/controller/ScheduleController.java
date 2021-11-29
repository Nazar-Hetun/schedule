package elinext.schedule.controller;

import elinext.schedule.dto.response.GroupResponseDto;
import elinext.schedule.dto.response.StudentResponseDto;
import elinext.schedule.mapper.GroupMapper;
import elinext.schedule.mapper.StudentMapper;
import elinext.schedule.service.GroupService;
import elinext.schedule.service.StudentService;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class ScheduleController {
    private static final String DATE_PATTERN = "dd.MM.yyyy";
    private StudentService studentService;
    private StudentMapper studentMapper;
    private GroupService groupService;
    private GroupMapper groupMapper;

    public ScheduleController(StudentService studentService, StudentMapper studentMapper, GroupService groupService, GroupMapper groupMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    @GetMapping("/")
    public GroupResponseDto getSchedule(@RequestParam String studentName,
                                           @RequestParam @DateTimeFormat(pattern = DATE_PATTERN)
                                                   LocalDate localDate) {
        StudentResponseDto studentResponseDto = studentMapper
                .mapToDto(studentService.getByName(studentName));
       return groupMapper.mapToDto(groupService
                .findByIdAndDayOfWeek(studentResponseDto.getGroupId(), localDate.getDayOfWeek()));
    }
}
