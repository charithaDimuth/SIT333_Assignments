package test.selenium;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateAndScienceSeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testQ1_Addition() throws InterruptedException {
        login();
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("7");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("/q2"));
    }

    @Test
    public void testQ2_Subtraction() throws InterruptedException {
        goToQ2();
        driver.findElement(By.name("number1")).sendKeys("10");
        driver.findElement(By.name("number2")).sendKeys("5");
        driver.findElement(By.name("result")).sendKeys("5");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("/q3"));
    }

    @Test
    public void testQ3_Multiplication() throws InterruptedException {
        goToQ3();
        driver.findElement(By.name("number1")).sendKeys("2");
        driver.findElement(By.name("number2")).sendKeys("5");
        driver.findElement(By.name("result")).sendKeys("10");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("/q4"));
    }

    @Test
    public void testQ4_NextDate() throws InterruptedException {
        goToQ4();
        driver.findElement(By.name("inputDate")).sendKeys("2025-05-21");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);

        assertTrue(driver.getPageSource().contains("Next date is: 2025-05-22"));
    }

    @Test
    public void testQ5_PreviousDate() throws InterruptedException {
        goToQ5();
        driver.findElement(By.name("inputDate")).sendKeys("2025-05-21");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);

        assertTrue(driver.getPageSource().contains("Previous date is: 2025-05-20"));
    }

    @Test
    public void testQ6_GravitationalForce() throws InterruptedException {
        goToQ6();
        driver.findElement(By.name("mass1")).sendKeys("5.972e24");
        driver.findElement(By.name("mass2")).sendKeys("7.348e22");
        driver.findElement(By.name("distance")).sendKeys("384400000");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);

        assertTrue(driver.getPageSource().contains("Gravitational Force:"));
    }

    // 🔁 Helper methods

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

    private void goToQ4() throws InterruptedException {
        goToQ3();
        driver.findElement(By.name("number1")).sendKeys("2");
        driver.findElement(By.name("number2")).sendKeys("5");
        driver.findElement(By.name("result")).sendKeys("10");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(1000);
    }

    private void goToQ5() throws InterruptedException {
        goToQ4();
        driver.findElement(By.name("inputDate")).sendKeys("2025-05-21");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);
    }

    private void goToQ6() throws InterruptedException {
        goToQ5();
        driver.findElement(By.name("inputDate")).sendKeys("2025-05-21");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);
    }
}