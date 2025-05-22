package com.github.mattcanovas.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import com.github.mattcanovas.processors.PaymentProcessor;
import com.github.mattcanovas.services.implementations.CheckoutService;

public class CheckoutServiceTest {

    private static final Integer ONE = 1;

    @Test
    public void testMockObjectConstruction() {
        try(MockedConstruction<PaymentProcessor> mocked = mockConstruction(PaymentProcessor.class, (mock, context) -> {
            when(mock.chargerCustomer(anyString(), any(BigDecimal.class))).thenReturn(BigDecimal.TEN);
        })) {
            CheckoutService service = new CheckoutService();
            BigDecimal result = service.purchaseProduct("MacBook Pro", "42");
            assertThat(result, is(BigDecimal.TEN));
            assertThat(mocked.constructed().size(), is(ONE));
        }
    }

}
