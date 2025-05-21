package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestDateUtilityService {

    @Test
    public void testGetNextDateValid() {
        String result = DateUtilityService.getNextDate("2025-05-21");
        assertEquals("2025-05-22", result);
    }

    @Test
    public void testGetPreviousDateValid() {
        String result = DateUtilityService.getPreviousDate("2025-05-21");
        assertEquals("2025-05-20", result);
    }

    @Test
    public void testGetNextDateInvalidFormat() {
        String result = DateUtilityService.getNextDate("21-05-2025");
        assertEquals("Invalid date format", result);
    }

    @Test
    public void testGetPreviousDateInvalidFormat() {
        String result = DateUtilityService.getPreviousDate("May 21, 2025");
        assertEquals("Invalid date format", result);
    }
}