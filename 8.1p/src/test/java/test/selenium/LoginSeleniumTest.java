package test.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class LoginSeleniumTest {

	private WebDriver driver;

	@Before
	public void setUp() {
		// Replace with your actual ChromeDriver path if not globally set
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

		driver = new ChromeDriver();
		driver.get("http://localhost:8080/login");
	}

	@Test
	public void testValidLogin() {
		driver.findElement(By.name("username")).sendKeys("ahsan");
		driver.findElement(By.name("passwd")).sendKeys("ahsan_pass");
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Page Title: " + driver.getTitle());
		WebElement heading = driver.findElement(By.tagName("h2"));
		System.out.println("Heading Text: " + heading.getText());

		assertEquals("Q1", heading.getText());
	}

	@Test
	public void testInvalidLogin() {
		driver.findElement(By.name("username")).sendKeys("wrong");
		driver.findElement(By.name("passwd")).sendKeys("user");
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		assertTrue(driver.getCurrentUrl().contains("/login"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
	// Q1 tests
	@Test
	public void testQ1_CorrectAnswer() throws InterruptedException {
		login();
		driver.findElement(By.name("number1")).sendKeys("3");
		driver.findElement(By.name("number2")).sendKeys("4");
		driver.findElement(By.name("result")).sendKeys("7");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
		assertEquals("Q2", driver.findElement(By.tagName("h2")).getText());
	}

	@Test
	public void testQ1_WrongAnswer() throws InterruptedException {
		login();
		driver.findElement(By.name("number1")).sendKeys("3");
		driver.findElement(By.name("number2")).sendKeys("4");
		driver.findElement(By.name("result")).sendKeys("8"); // wrong
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
		assertEquals("Q1", driver.findElement(By.tagName("h2")).getText());
		assertTrue(driver.getPageSource().contains("Wrong answer"));
	}

	@Test
	public void testQ1_InvalidInput() throws InterruptedException {
		login();
		driver.findElement(By.name("number1")).sendKeys("a");
		driver.findElement(By.name("number2")).sendKeys("4");
		driver.findElement(By.name("result")).sendKeys("8");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
		assertEquals("Q1", driver.findElement(By.tagName("h2")).getText());
		assertTrue(driver.getPageSource().contains("Invalid input"));
	}
	
	//Q2 Tests
	@Test
	public void testQ2_CorrectAnswer() throws InterruptedException {
		goToQ2();
		driver.findElement(By.name("number1")).sendKeys("10");
		driver.findElement(By.name("number2")).sendKeys("5");
		driver.findElement(By.name("result")).sendKeys("5");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
		assertEquals("Q3", driver.findElement(By.tagName("h2")).getText());
	}

	@Test
	public void testQ2_WrongAnswer() throws InterruptedException {
		goToQ2();
		driver.findElement(By.name("number1")).sendKeys("10");
		driver.findElement(By.name("number2")).sendKeys("5");
		driver.findElement(By.name("result")).sendKeys("6");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
		assertEquals("Q2", driver.findElement(By.tagName("h2")).getText());
		assertTrue(driver.getPageSource().contains("Wrong answer"));
	}

	@Test
	public void testQ2_InvalidInput() throws InterruptedException {
		goToQ2();
		driver.findElement(By.name("number1")).sendKeys("");
		driver.findElement(By.name("number2")).sendKeys("5");
		driver.findElement(By.name("result")).sendKeys("5");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
		assertEquals("Q2", driver.findElement(By.tagName("h2")).getText());
		assertTrue(driver.getPageSource().contains("Invalid input"));
	}
	
	//Q3 Tests
	@Test
	public void testQ3_CorrectAnswer() throws InterruptedException {
		goToQ3();
		driver.findElement(By.name("number1")).sendKeys("2");
		driver.findElement(By.name("number2")).sendKeys("5");
		driver.findElement(By.name("result")).sendKeys("10");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
		assertTrue(driver.getPageSource().contains("Congratulations"));
	}

	@Test
	public void testQ3_WrongAnswer() throws InterruptedException {
		goToQ3();
		driver.findElement(By.name("number1")).sendKeys("2");
		driver.findElement(By.name("number2")).sendKeys("5");
		driver.findElement(By.name("result")).sendKeys("9");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
		assertEquals("Q3", driver.findElement(By.tagName("h2")).getText());
		assertTrue(driver.getPageSource().contains("Wrong answer"));
	}

	@Test
	public void testQ3_InvalidInput() throws InterruptedException {
		goToQ3();
		driver.findElement(By.name("number1")).sendKeys("2");
		driver.findElement(By.name("number2")).sendKeys("five");
		driver.findElement(By.name("result")).sendKeys("10");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
		assertEquals("Q3", driver.findElement(By.tagName("h2")).getText());
		assertTrue(driver.getPageSource().contains("Invalid input"));
	}
	
	// Helpers
	
	private void login() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("ahsan");
		driver.findElement(By.name("passwd")).sendKeys("ahsan_pass");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
	}

	private void goToQ2() throws InterruptedException {
		login();
		driver.findElement(By.name("number1")).sendKeys("3");
		driver.findElement(By.name("number2")).sendKeys("4");
		driver.findElement(By.name("result")).sendKeys("7");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
	}

	private void goToQ3() throws InterruptedException {
		goToQ2();
		driver.findElement(By.name("number1")).sendKeys("10");
		driver.findElement(By.name("number2")).sendKeys("5");
		driver.findElement(By.name("result")).sendKeys("5");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
	}
}