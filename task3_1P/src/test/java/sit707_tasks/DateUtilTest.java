package sit707_tasks;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

/**
 * Author: Ahsan Habib  
 * Completed by: W.A. Charitha Dimuth Wickramanayake  
 * Student ID: s225094448  
 */

public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "s225094448";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "W.A. Charitha Dimuth Wickramanayake";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.increment();
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMaxJanuary31ShouldDecrementToJanuary30() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testNominalJanuary() {
        int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        date.increment();
    }

    @Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // Previous Date Test Cases

    @Test
    public void testPreviousDate_1A() {
        DateUtil date = new DateUtil(1, 6, 1994);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(5, date.getMonth());
    }

    @Test
    public void testPreviousDate_2A() {
        DateUtil date = new DateUtil(2, 6, 1994);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testPreviousDate_3A() {
        DateUtil date = new DateUtil(15, 6, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testPreviousDate_4A() {
        DateUtil date = new DateUtil(30, 6, 1994);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPreviousDate_5A_Invalid() {
        new DateUtil(31, 6, 1994); // June has only 30 days
    }

    @Test
    public void testPreviousDate_6A() {
        DateUtil date = new DateUtil(15, 1, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testPreviousDate_7A() {
        DateUtil date = new DateUtil(15, 2, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void testPreviousDate_8A() {
        DateUtil date = new DateUtil(15, 11, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(11, date.getMonth());
    }

    @Test
    public void testPreviousDate_9A() {
        DateUtil date = new DateUtil(15, 12, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(12, date.getMonth());
    }

    @Test
    public void testPreviousDate_10A() {
        DateUtil date = new DateUtil(15, 6, 1700);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testPreviousDate_11A() {
        DateUtil date = new DateUtil(15, 6, 1701);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testPreviousDate_12A() {
        DateUtil date = new DateUtil(15, 6, 2023);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testPreviousDate_13A() {
        DateUtil date = new DateUtil(15, 6, 2024);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    // Next Date Test Cases

    @Test
    public void testNextDate_1B() {
        DateUtil date = new DateUtil(1, 6, 1994);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testNextDate_2B() {
        DateUtil date = new DateUtil(2, 6, 1994);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testNextDate_3B() {
        DateUtil date = new DateUtil(15, 6, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testNextDate_4B() {
        DateUtil date = new DateUtil(30, 6, 1994);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextDate_5B_Invalid() {
        new DateUtil(31, 6, 1994); // June has only 30 days
    }

    @Test
    public void testNextDate_6B() {
        DateUtil date = new DateUtil(15, 1, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testNextDate_7B() {
        DateUtil date = new DateUtil(15, 2, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void testNextDate_8B() {
        DateUtil date = new DateUtil(15, 11, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(11, date.getMonth());
    }

    @Test
    public void testNextDate_9B() {
        DateUtil date = new DateUtil(15, 12, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(12, date.getMonth());
    }

    @Test
    public void testNextDate_10B() {
        DateUtil date = new DateUtil(15, 6, 1700);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testNextDate_11B() {
        DateUtil date = new DateUtil(15, 6, 1701);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testNextDate_12B() {
        DateUtil date = new DateUtil(15, 6, 2023);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testNextDate_13B() {
        DateUtil date = new DateUtil(15, 6, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }
}