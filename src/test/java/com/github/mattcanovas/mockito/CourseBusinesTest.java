package com.github.mattcanovas.mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.mattcanovas.business.CourseBusiness;
import com.github.mattcanovas.services.ICourseService;

@ExtendWith(MockitoExtension.class)
public class CourseBusinesTest {

    @Mock
    private ICourseService service;

    @InjectMocks
    private CourseBusiness business;

    @Captor
    private ArgumentCaptor<String> argumentCaptor;

    private List<String> courses;

    @BeforeEach
    public void setup() {
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
    public void testCoursesRelatedToSpring_When_UsingAMock() {
        given(service.retrieveCourses("Matheus")).willReturn(courses);
        List<String> filteredCourses = business.retrieveCoursesRelatedToSpring("Matheus");
        assertThat(filteredCourses.getClass(), is(ArrayList.class));
        assertThat(filteredCourses.size(), is(4));
    }

    @Test
    public void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod() {
        given(service.retrieveCourses("Matheus")).willReturn(courses);
        business.deleteCoursesNotRelatedToSpring("Matheus");
        verify(service).deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
    }

    @Test
    public void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCourse() {
        given(service.retrieveCourses("Matheus")).willReturn(courses);
        business.deleteCoursesNotRelatedToSpring("Matheus");
        then(service)
                .should()
                .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        then(service)
                .should(never())
                .deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker");
    }

    @Test
    public void testDeleteCoursesNotRelatedToSpring_CaputringArguments_Should_CallMethod_deleteCourses() {
        given(service.retrieveCourses("Matheus")).willReturn(courses);

        business.deleteCoursesNotRelatedToSpring("Matheus");

        then(service).should(times(7)).deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }

}
