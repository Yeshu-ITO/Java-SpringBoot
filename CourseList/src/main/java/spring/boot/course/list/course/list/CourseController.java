package spring.boot.course.list.course.list;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/Courses")
    public List<Course> allCourses(){
        return Arrays.asList(
                new Course(1,"Java"),
                new Course(2,"XML"),
                new Course(3,"MarkLogic")
                );
    }
}
