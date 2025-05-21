package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtilityService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getNextDate(String dateStr) {
        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return date.plusDays(1).format(formatter);
        } catch (DateTimeParseException e) {
            return "Invalid date format";
        }
    }

    public static String getPreviousDate(String dateStr) {
        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return date.minusDays(1).format(formatter);
        } catch (DateTimeParseException e) {
            return "Invalid date format";
        }
    }
}