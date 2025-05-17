package com.github.mattcanovas.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.github.mattcanovas.services.ICourseService;

public class CourseBusiness {

    private ICourseService service;

    public CourseBusiness(ICourseService service) {
        this.service = service;
    }

    public List<String> retrieveCoursesRelatedToSpring(String student) {
        if ("FooBar".equals(student)) return new ArrayList<>();
        return service.retrieveCourses(student)
            .stream()
            .filter((course) -> course.contains("Spring"))
            .collect(Collectors.toList());
    }

    public void deleteCoursesNotRelatedToSpring(String student) {
        List<String> allCourses = service.retrieveCourses(student);
        allCourses
            .stream()
            .forEach((course) -> {
                if (!course.contains("Spring")) service.deleteCourse(course);
            });
    }

}
