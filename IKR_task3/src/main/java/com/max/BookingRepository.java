package com.max;

import java.time.LocalDateTime;

public interface BookingRepository {
    boolean checkTimeInBD(LocalDateTime from, LocalDateTime to);
    boolean createBook(String userId, LocalDateTime from, LocalDateTime to);
}
