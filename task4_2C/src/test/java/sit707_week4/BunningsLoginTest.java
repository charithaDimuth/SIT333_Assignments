package sit707_week4;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BunningsLoginTest {  

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/Downloads/chromedriver-mac-arm64-2/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");  
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.clear();
        usernameField.sendKeys("charitha.cdw@gmail.com");   // Valid username
        passwordField.clear();
        passwordField.sendKeys("Charitha@24466");     //  Valid password
        loginButton.click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        assertTrue("Expected to be redirected to inventory page after valid login",
                   currentUrl.contains("inventory"));
    }

    @Test
    public void testInvalidPassword() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.clear();
        usernameField.sendKeys("standard_user");   // Valid username
        passwordField.clear();
        passwordField.sendKeys("wrong_password");  //  Wrong password
        loginButton.click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        assertTrue("Expected to stay on login page after wrong password",
                   currentUrl.contains("saucedemo.com"));
    }

    @Test
    public void testInvalidUsername() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.clear();
        usernameField.sendKeys("wrong_user");       //  Wrong username
        passwordField.clear();
        passwordField.sendKeys("secret_sauce");     // Valid password
        loginButton.click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        assertTrue("Expected to stay on login page after wrong username",
                   currentUrl.contains("saucedemo.com"));
    }

    @Test
    public void testInvalidUsernameAndPassword() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.clear();
        usernameField.sendKeys("wrong_user");        //  Wrong username
        passwordField.clear();
        passwordField.sendKeys("wrong_password");    //  Wrong password
        loginButton.click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        assertTrue("Expected to stay on login page after wrong username and password",
                   currentUrl.contains("saucedemo.com"));
    }
}