package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private static final long GIGA_SECOND = 1_000_000_000;

    LocalDateTime dateTime;

    public Gigasecond(LocalDate moment) {
        this(moment.atTime(0, 0, 0));
    }

    public Gigasecond(LocalDateTime moment) {
        this.dateTime = moment.plusSeconds(GIGA_SECOND);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
