package com.max;

import java.time.LocalDateTime;

public class BookingService {
    private final BookingRepository repo;

    public BookingService(BookingRepository repo) {
        this.repo = repo;
    }

    public boolean book(String userId, LocalDateTime from, LocalDateTime to) throws CantBookException {
        if (repo.checkTimeInBD(from, to)) {
            return repo.createBook(userId, from, to);
        }
        throw new CantBookException();
    }

    public boolean checkTimeInBD(LocalDateTime from, LocalDateTime to) {
        return false;
    }

    public boolean createBook(String userId, LocalDateTime from, LocalDateTime to) {
        return false;
    }
}
