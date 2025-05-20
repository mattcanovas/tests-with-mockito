package com.github.mattcanovas.mockito;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {

    @Test
    public void testHamcrestMatchers() {
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(100, 101));
        assertThat(scores, everyItem(greaterThan(98)));
        assertThat(scores, everyItem(lessThan(106)));
    }

    @Test
    public void testHamcrestMatchersWithStrings() {
        assertThat("", is(emptyString()));
        assertThat(null, is(emptyOrNullString()));
    }

    @Test
    public void testHamcrestMatchersWithArray() {
        Integer[] array = { 1, 2, 3 };
        assertThat(array, arrayWithSize(3));
        assertThat(array, arrayContaining(1, 2, 3));
        assertThat(array, arrayContainingInAnyOrder(3, 2, 1));
    }

}
