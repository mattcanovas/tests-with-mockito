package com.github.mattcanovas;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SpytTest {

    @Test
    public void whenCreateMock_thenCreate() {
        List<String> mockedList = mock(ArrayList.class);

        mockedList.add("one");
        verify(mockedList).add("one");

        assertThat(mockedList, hasSize(0));
    }

    @Test
    public void whenCreateSpy_thenCreate() {
        List<String> spyList = spy(ArrayList.class);

        spyList.add("one");
        verify(spyList).add("one");

        assertThat(spyList, hasSize(1));
    }

}
