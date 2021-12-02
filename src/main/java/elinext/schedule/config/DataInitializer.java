package elinext.schedule.config;

import elinext.schedule.model.Class;
import elinext.schedule.model.Classroom;
import elinext.schedule.model.Student;
import elinext.schedule.model.StudentGroup;
import elinext.schedule.service.ClassService;
import elinext.schedule.service.ClassroomService;
import elinext.schedule.service.StudentGroupService;
import elinext.schedule.service.StudentService;
import java.time.DayOfWeek;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final ClassroomService classroomService;
    private final ClassService classService;
    private final StudentGroupService studentGroupService;
    private final StudentService studentService;

    public DataInitializer(ClassroomService classroomService,
                           ClassService classService,
                           StudentGroupService studentGroupService,
                           StudentService studentService) {
        this.classroomService = classroomService;
        this.classService = classService;
        this.studentGroupService = studentGroupService;
        this.studentService = studentService;
    }

    @PostConstruct
    private void initialize() {
        Classroom classroom1 = new Classroom();
        classroom1.setEducationalBuildingNumber(1);
        classroom1.setRoomNumber(101);
        classroomService.add(classroom1);

        Classroom classroom2 = new Classroom();
        classroom2.setEducationalBuildingNumber(1);
        classroom2.setRoomNumber(102);
        classroomService.add(classroom2);

        Classroom classroom3 = new Classroom();
        classroom3.setEducationalBuildingNumber(2);
        classroom3.setRoomNumber(101);
        classroomService.add(classroom3);

        Class clazz1 = new Class();
        clazz1.setDayOfWeek(DayOfWeek.MONDAY);
        clazz1.setSubject("Math");
        clazz1.setClassroom(classroom1);
        classService.add(clazz1);

        Class clazz2 = new Class();
        clazz2.setDayOfWeek(DayOfWeek.MONDAY);
        clazz2.setSubject("Biology");
        clazz2.setClassroom(classroom2);
        classService.add(clazz2);

        Class clazz3 = new Class();
        clazz3.setDayOfWeek(DayOfWeek.TUESDAY);
        clazz3.setSubject("Math");
        clazz3.setClassroom(classroom3);
        classService.add(clazz3);

        Class clazz4 = new Class();
        clazz4.setDayOfWeek(DayOfWeek.WEDNESDAY);
        clazz4.setSubject("English");
        clazz4.setClassroom(classroom3);
        classService.add(clazz4);

        Class clazz5 = new Class();
        clazz5.setDayOfWeek(DayOfWeek.THURSDAY);
        clazz5.setSubject("Biology");
        clazz5.setClassroom(classroom1);
        classService.add(clazz5);

        Class clazz6 = new Class();
        clazz6.setDayOfWeek(DayOfWeek.FRIDAY);
        clazz6.setSubject("English");
        clazz6.setClassroom(classroom2);
        classService.add(clazz6);

        Class clazz7 = new Class();
        clazz7.setDayOfWeek(DayOfWeek.FRIDAY);
        clazz7.setSubject("Math");
        clazz7.setClassroom(classroom2);
        classService.add(clazz7);

        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setClasses(List.of(clazz1, clazz2, clazz3, clazz4, clazz5, clazz6, clazz7));
        studentGroup.setName("DE-51");
        studentGroupService.add(studentGroup);

        Student nazar = new Student();
        nazar.setName("Nazar");
        nazar.setStudentGroup(studentGroup);
        studentService.add(nazar);

        Student andrew = new Student();
        andrew.setName("Andrew");
        andrew.setStudentGroup(studentGroup);
        studentService.add(andrew);

        Student olga = new Student();
        olga.setName("Olga");
        olga.setStudentGroup(studentGroup);
        studentService.add(olga);
    }
}
