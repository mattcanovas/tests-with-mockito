package com.github.mattcanovas.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.mattcanovas.services.ICourseService;

public class CourseBusinessMockTest {

    private ICourseService service;
    private CourseBusiness business;
    private List<String> courses;
    @BeforeEach
    public void setup() {
        service = mock(ICourseService.class);
        business = new CourseBusiness(service);
        courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
    }

    @Test
    public void testCoursesRelatedToSpring_When_UsingAStub() {
        when(service.retrieveCourses("Matheus")).thenReturn(courses);
        List<String> filteredCourses = business.retrieveCoursesRelatedToSpring("Matheus");
        assertEquals(4, filteredCourses.size());
    }

}
