package com.github.mattcanovas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {

    @Test
    public void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnMatheus() {
        List<String> nomes = mock(List.class);
        when(nomes.get(anyInt())).thenReturn("Matheus");

        assertEquals("Matheus", nomes.get(0));
        assertEquals("Matheus", nomes.get(3));
        assertEquals("Matheus", nomes.get(anyInt()));
    }

    @Test
    public void testMockingList_When_GetIsCalled_ShouldThrowRuntimeException() {
        List<String> nomes = mock(List.class);
        when(nomes.size()).thenThrow(new RuntimeException("Runtime exception was throwed!"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            nomes.size();
        });
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Runtime exception was throwed!", exception.getMessage());
    }

}
