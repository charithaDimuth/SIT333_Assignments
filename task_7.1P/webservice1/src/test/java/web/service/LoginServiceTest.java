package web.service;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Selenium functional tests for login page.
 */
public class LoginServiceTest {

    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        // Set your correct chromedriver path
        System.setProperty("webdriver.chrome.driver", "/Users/admin/Downloads/chromedriver-mac-arm64-2/chromedriver");
        driver = new ChromeDriver();

        // Open login.html from local file
        driver.get("http://127.0.0.1:8082/login.html");
        
        // Wait for page to load properly
        Thread.sleep(2000);
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        Thread.sleep(500);

        driver.findElement(By.id("username")).sendKeys("admin"); // ✅ Add this line
        Thread.sleep(500);

        driver.findElement(By.id("passwd")).sendKeys("1234");
        Thread.sleep(500);

        driver.findElement(By.id("dob")).sendKeys("2000-01-01");
        Thread.sleep(500);

        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(3000);

        assertEquals("success", driver.getTitle());
    }

    @Test
    public void testInvalidLogin() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("wrong");
        Thread.sleep(500);

        driver.findElement(By.id("passwd")).sendKeys("wrong");
        Thread.sleep(500);

        driver.findElement(By.id("dob")).sendKeys("1990-01-01");
        Thread.sleep(500);

        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(3000);

        assertEquals("fail", driver.getTitle());
    }
    
    @Test
    public void testEmptyFields() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("");
        Thread.sleep(300);

        driver.findElement(By.id("passwd")).sendKeys("");
        Thread.sleep(300);

        driver.findElement(By.id("dob")).sendKeys("");
        Thread.sleep(300);

        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(2000);

        assertEquals("fail", driver.getTitle());
    }
    
    @Test
    public void testOnlyValidDOB() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("wrong");
        Thread.sleep(300);

        driver.findElement(By.id("passwd")).sendKeys("wrong");
        Thread.sleep(300);

        driver.findElement(By.id("dob")).sendKeys("2000-01-01");
        Thread.sleep(300);

        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(2000);

        assertEquals("fail", driver.getTitle());
    }
    
    @Test
    public void testLongUsernameInput() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("averyveryverylongusername123456");
        driver.findElement(By.id("passwd")).sendKeys("1234");
        driver.findElement(By.id("dob")).sendKeys("2000-01-01");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(2000);

        assertEquals("fail", driver.getTitle());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}