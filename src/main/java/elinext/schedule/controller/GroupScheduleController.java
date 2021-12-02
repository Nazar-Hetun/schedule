package elinext.schedule.controller;

import elinext.schedule.dto.response.StudentGroupResponseDto;
import elinext.schedule.dto.response.StudentResponseDto;
import elinext.schedule.mapper.StudentGroupMapper;
import elinext.schedule.mapper.StudentMapper;
import elinext.schedule.service.StudentGroupService;
import elinext.schedule.service.StudentService;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GroupScheduleController {
    private static final String DATE_PATTERN = "dd.MM.yyyy";
    private StudentService studentService;
    private StudentMapper studentMapper;
    private StudentGroupService studentGroupService;
    private StudentGroupMapper studentGroupMapper;

    public GroupScheduleController(StudentService studentService,
                                   StudentMapper studentMapper,
                                   StudentGroupService studentGroupService,
                                   StudentGroupMapper studentGroupMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
        this.studentGroupService = studentGroupService;
        this.studentGroupMapper = studentGroupMapper;
    }

    @GetMapping
    public StudentGroupResponseDto getSchedule(@RequestParam String studentName,
                                               @RequestParam @DateTimeFormat(pattern = DATE_PATTERN)
                                                   LocalDate localDate) {
        StudentResponseDto studentResponseDto = studentMapper
                .mapToDto(studentService.getByName(studentName));
        return studentGroupMapper.mapToDto(studentGroupService
                .findByIdAndDayOfWeek(studentResponseDto.getGroupId(), localDate.getDayOfWeek()));
    }
}
