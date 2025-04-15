package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Completed by: W.A. Charitha Dimuth Wickramanayake  
 * Student ID: s225094448  
 */
public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "s225094448";
        Assert.assertNotNull("Student ID is null", studentId);
        Assert.assertEquals("s225094448", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "W.A. Charitha Dimuth Wickramanayake";
        Assert.assertNotNull("Student name is null", studentName);
        Assert.assertEquals("W.A. Charitha Dimuth Wickramanayake", studentName);
    }

    // 1A
    @Test
    public void testPreviousDate_1A() {
        DateUtil date = new DateUtil(1, 6, 1994);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    // 2A
    @Test
    public void testPreviousDate_2A() {
        DateUtil date = new DateUtil(2, 6, 1994);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    // 3A
    @Test
    public void testPreviousDate_3A() {
        DateUtil date = new DateUtil(15, 6, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    // 4A
    @Test
    public void testPreviousDate_4A() {
        DateUtil date = new DateUtil(30, 6, 1994);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    // 5A - Invalid (31 June)
    @Test(expected = IllegalArgumentException.class)
    public void testPreviousDate_5A_Invalid() {
        new DateUtil(31, 6, 1994);
    }

    // 6A
    @Test
    public void testPreviousDate_6A() {
        DateUtil date = new DateUtil(15, 1, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    // 7A
    @Test
    public void testPreviousDate_7A() {
        DateUtil date = new DateUtil(15, 2, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    // 8A
    @Test
    public void testPreviousDate_8A() {
        DateUtil date = new DateUtil(15, 11, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(11, date.getMonth());
    }

    // 9A
    @Test
    public void testPreviousDate_9A() {
        DateUtil date = new DateUtil(15, 12, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(12, date.getMonth());
    }

    // 10A
    @Test
    public void testPreviousDate_10A() {
        DateUtil date = new DateUtil(15, 6, 1700);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    // 11A
    @Test
    public void testPreviousDate_11A() {
        DateUtil date = new DateUtil(15, 6, 1701);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    // 12A
    @Test
    public void testPreviousDate_12A() {
        DateUtil date = new DateUtil(15, 6, 2023);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    // 13A
    @Test
    public void testPreviousDate_13A() {
        DateUtil date = new DateUtil(15, 6, 2024);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    // === NEXT DATE TESTS ===

    // 1B
    @Test
    public void testNextDate_1B() {
        DateUtil date = new DateUtil(1, 6, 1994);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    // 2B
    @Test
    public void testNextDate_2B() {
        DateUtil date = new DateUtil(2, 6, 1994);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    // 13B
    @Test
    public void testNextDate_13B() {
        DateUtil date = new DateUtil(15, 6, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }
}