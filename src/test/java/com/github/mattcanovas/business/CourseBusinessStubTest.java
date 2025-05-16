package com.github.mattcanovas.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.mattcanovas.services.stubs.CourseServiceStub;

public class CourseBusinessStubTest {
    
    private CourseBusiness business;

    @BeforeEach
    public void setup() {
        business = new CourseBusiness(new CourseServiceStub());
    }

    @Test
    public void testCoursesRelatedToSpring_When_UsingAStub() {
        List<String> filteredCourses = business.retrieveCoursesRelatedToSpring("Matheus");
        assertEquals(4, filteredCourses.size());
    } 

    @Test
    public void testCoursesRelatedToSpring_When_UsingAFooBarStudent() {
        List<String> filteredCourses = business.retrieveCoursesRelatedToSpring("FooBar");
        assertEquals(0, filteredCourses.size());
    }

}
