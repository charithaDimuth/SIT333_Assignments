package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
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
	public void testFalseNumberIsEven() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(7));
	}

	@Test
	public void testCancelWeatherAdvice() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
	}

	// isEven Tests
	@Test
	public void testIsEvenTrue() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(4));
	}

	@Test
	public void testIsEvenFalse() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(5));
	}

	@Test
	public void testIsEvenZero() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(0));
	}

	// isPrime Tests
	@Test
	public void testIsPrimeTrue() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
	}

	@Test
	public void testIsPrimeFalse() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(6));
	}

	@Test
	public void testIsPrimeZero() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(0));
	}

	@Test
	public void testIsPrimeOne() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
	}

	@Test
	public void testIsPrimeNegative() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(-3));
	}

	// Weather Advice Test Variants
	@Test
	public void testDangerousWeatherHighWind() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(71.0, 3.0));
	}

	@Test
	public void testDangerousWeatherHighRain() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(30.0, 6.5));
	}

	@Test
	public void testDangerousWeatherBoth() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 4.5));
	}

	@Test
	public void testWarningWeatherWindOnly() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 2.0));
	}

	@Test
	public void testWarningWeatherRainOnly() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(30.0, 4.5));
	}

	@Test
	public void testAllClearWeather() {
		Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(30.0, 2.0));
	}
}