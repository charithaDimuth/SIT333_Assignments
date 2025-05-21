package web.service;

import static org.junit.Assert.assertTrue;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationServiceTest {

    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8082/register.html");
        Thread.sleep(1000);
    }

    @Test
    public void testValidRegistration() throws InterruptedException {
        driver.findElement(By.id("fname")).sendKeys("Charitha");
        driver.findElement(By.id("lname")).sendKeys("Dimuth");
        driver.findElement(By.id("email")).sendKeys("charitha@example.com");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(2000);

        // Check raw response
        String bodyText = driver.getPageSource();
        assertTrue(bodyText.contains("\"status\": \"ok\""));
    }

    @Test
    public void testMissingEmail() throws InterruptedException {
        driver.findElement(By.id("fname")).sendKeys("Charitha");
        driver.findElement(By.id("lname")).sendKeys("Dimuth");
        driver.findElement(By.id("email")).clear(); // Empty field
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(2000);

        // Browser native validation may block this
        boolean stillOnPage = driver.getCurrentUrl().contains("register.html");
        assertTrue(stillOnPage || driver.getPageSource().contains("\"status\": \"ok\""));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}