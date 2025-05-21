package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "S225094448";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Charitha Dimuth";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testFalseNumberIsEven() {
	    Assert.assertFalse(WeatherAndMathUtils.isEven(3)); // 3 is odd
	}
	
    @Test
    public void testCancelWeatherAdvice() {
    	Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }
    
 // R – Right: Correct output
    @Test
    public void testTrueNumberIsEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(2));
    }

    // B – Boundary: wind speed at dangerous level
    @Test
    public void testBoundaryWeatherAdvice_DangerousWind() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

    // I – Invalid input: negative wind speed
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidWeatherAdvice_NegativeInput() {
        WeatherAndMathUtils.weatherAdvice(-5.0, 2.0);
    }

    // C – Check for low, normal input
    @Test
    public void testAllClearWeatherAdvice() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(10.0, 2.0));
    }

    // E – Edge case: wind just over concerning, rain under
    @Test
    public void testWarnWeatherAdvice() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 3.0));
    }

    // P – Prime testing edge case
    @Test
    public void testIsPrimeWith2() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2)); // Should be prime
    }

    @Test
    public void testIsPrimeWithEven() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4)); // Not prime
    }

    @Test
    public void testIsPrimeWithOddNonPrime() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(9)); // Not prime
    }
}
