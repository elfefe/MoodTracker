package com.moodtracker.elfefe.moodtracker.utils;

import org.threeten.bp.LocalDate;

public class TimeUtils {
    public static Integer getDate() {
        LocalDate now = LocalDate.now();
        return now.getYear() * 1_000 + now.getDayOfYear();
    }

    public static Integer getDate(int minusDays) {
        LocalDate now = LocalDate.now();
        int someDaysAgo;

        if (now.getDayOfYear() - minusDays < 0) {
            int dayInYear = 365;
            if (now.isLeapYear()) {
                dayInYear = 366;
            }
            someDaysAgo = (now.getYear() - 1) * 1_000 + (dayInYear - minusDays + now.getDayOfYear());
        } else {
            someDaysAgo = getDate() - minusDays;
        }

        return someDaysAgo;
    }

}
