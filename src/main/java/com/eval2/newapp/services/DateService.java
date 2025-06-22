package com.eval2.newapp.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class DateService {
    public long getMonthBetween(LocalDate startDate, LocalDate endDate) {
        startDate = startDate.withDayOfMonth(1);
        endDate = endDate.withDayOfMonth(1);

        long monthsBetween = Math.abs(startDate.until(endDate, ChronoUnit.MONTHS));
        return monthsBetween+1;
    }
}
