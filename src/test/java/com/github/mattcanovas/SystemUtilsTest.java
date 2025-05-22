package com.github.mattcanovas;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import com.github.mattcanovas.utils.SystemUtils;

public class SystemUtilsTest {
    
    private static final String DEFAULT_WELCOME_MESSAGE = "Howdy Matheus";

    @Test
    public void testGetWelcomeMessage_WhenCalledWithIsCustomerTrue_Should_ReturnDearCustomer() {
        try(MockedStatic<SystemUtils> mockedSystemUtils = mockStatic(SystemUtils.class)) {
            mockedSystemUtils.when(() -> SystemUtils.getWelcomeMessage(anyString(), anyBoolean())).thenReturn(DEFAULT_WELCOME_MESSAGE);

            String welcomeMessage = SystemUtils.getWelcomeMessage("Matheus", true);

            assertThat(welcomeMessage, is(DEFAULT_WELCOME_MESSAGE));
        }
    }

}
