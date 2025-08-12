package com.max;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(BookingServiceTest.class);

    private BookingRepository repo; // мок
    private BookingService bookingService; // тестируемый сервис

    @BeforeEach
    void setUp() {
        repo = mock(BookingRepository.class);
        bookingService = new BookingService(repo);
    }

    @Test
    void bookSuccessWhenTimeAvailable() throws CantBookException {
        LocalDateTime from = LocalDateTime.of(2025, 8, 12, 10, 0);
        LocalDateTime to = LocalDateTime.of(2025, 8, 12, 11, 0);

        when(repo.checkTimeInBD(from, to)).thenReturn(true);
        when(repo.createBook("user1", from, to)).thenReturn(true);

        logger.info("Тест: успешное бронирование при доступном слоте");
        boolean result = bookingService.book("user1", from, to);

        assertTrue(result);
        verify(repo).checkTimeInBD(from, to);
        verify(repo).createBook("user1", from, to);
    }

    @Test
    void bookFailsWhenTimeNotAvailable() {
        LocalDateTime from = LocalDateTime.of(2025, 8, 12, 14, 0);
        LocalDateTime to = LocalDateTime.of(2025, 8, 12, 15, 0);

        when(repo.checkTimeInBD(from, to)).thenReturn(false);

        logger.info("Тест: ошибка бронирования при занятости слота");
        CantBookException thrown = assertThrows(
                CantBookException.class,
                () -> bookingService.book("user2", from, to)
        );

        assertNotNull(thrown);
        verify(repo).checkTimeInBD(from, to);
        verify(repo, never()).createBook(any(), any(), any());
    }

}