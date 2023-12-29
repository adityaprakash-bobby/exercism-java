package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

        return LocalDateTime.parse(appointmentDateDescription, parser);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        LocalDateTime now = LocalDateTime.now();

        return appointmentDate.isBefore(now);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int hourOfDay = appointmentDate.getHour();

        return hourOfDay >= 12 && hourOfDay < 18;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("`Y`o`u `h`a`v`e `a`n `a`p`p`o`i`n`t`m`e`n`t `o`n E, M W, Y, `a`t H:m a");
        //You have an appointment on Friday, March 29, 2019, at 3:00 PM.

        return appointmentDate.format(formatter);
    }

    public LocalDate getAnniversaryDate() {
        LocalDate anniversaryDate = LocalDate.of(LocalDate.now().getYear(), 9, 15);
        return anniversaryDate;
    }
}