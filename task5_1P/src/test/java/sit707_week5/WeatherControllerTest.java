package sit707_week5;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class WeatherControllerTest {

    // ✅ Identity test cases
    @Test
    public void testStudentIdentity() {
        String studentId = "s225094448"; // Your Student ID
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "W.A. Charitha Dimuth"; // Your Name
        Assert.assertNotNull("Student name is null", studentName);
    }

    // ✅ Shared WeatherController instance and cached values
    private static WeatherController controller;
    private static List<Double> hourlyTemps;

    @BeforeClass
    public static void setUp() {
        // Get the controller instance once
        controller = WeatherController.getInstance();

        // Store all hourly temperature values to avoid repeated delays
        hourlyTemps = new ArrayList<>();
        for (int i = 0; i < controller.getTotalHours(); i++) {
            hourlyTemps.add(controller.getTemperatureForHour(i + 1)); // Note: hour starts from 1
        }
    }

    @AfterClass
    public static void tearDown() {
        controller.close();
    }

    @Test
    public void testTemperatureMin() {
        // Arrange
        double expectedMin = Collections.min(hourlyTemps);

        // Act
        double actualMin = controller.getTemperatureMinFromCache();

        // Assert
        assertEquals("Minimum temperature mismatch", expectedMin, actualMin, 0.01);
    }

    @Test
    public void testTemperatureMax() {
        // Arrange
        double expectedMax = Collections.max(hourlyTemps);

        // Act
        double actualMax = controller.getTemperatureMaxFromCache();

        // Assert
        assertEquals("Maximum temperature mismatch", expectedMax, actualMax, 0.01);
    }

    @Test
    public void testTemperatureAverage() {
        // Arrange
        double sum = 0;
        for (double temp : hourlyTemps) {
            sum += temp;
        }
        double expectedAvg = sum / hourlyTemps.size();

        // Act
        double actualAvg = controller.getTemperatureAverageFromCache();

        // Assert
        assertEquals("Average temperature mismatch", expectedAvg, actualAvg, 0.01);
    }

    // 🔒 This test is beyond 5.1P – leave commented if not needed
    /*
    @Test
    public void testTemperaturePersist() {
        ...
    }
    */ 
}