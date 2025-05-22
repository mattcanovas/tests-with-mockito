package com.github.mattcanovas.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.internal.MockedStaticImpl;

import com.github.mattcanovas.entity.Order;
import com.github.mattcanovas.services.implementations.OrderService;

public class OrderServiceTest {
    
    private OrderService service = new OrderService();
    private static final UUID DEFAULT_UUID = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
    private static final LocalDateTime DEFAULT_LOCAL_DATE_TIME = LocalDateTime.of(2025, 5, 22, 10, 26, 30);

    @Test
    @DisplayName("Should include random OrderId when no OrderId exists.")
    public void testShouldIncludeRandomOrderId_When_NoOrderIdExists() {
        try(MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(DEFAULT_UUID);

            Order result = this.service.createOrder("MackBook Pro M4", 2L, null);
            
            assertEquals(result.getId(), DEFAULT_UUID.toString());
        }
    }

    @Test
    public void testShouldIncludeCurrentDateTime_When_CreateANewOrder() {
        try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
            mockedLocalDateTime.when(LocalDateTime::now).thenReturn(DEFAULT_LOCAL_DATE_TIME);

            Order result = this.service.createOrder("MackBook Pro M4", 2L, DEFAULT_UUID.toString());

            assertEquals(DEFAULT_LOCAL_DATE_TIME, result.getCreationDate());
        }
    }
}
