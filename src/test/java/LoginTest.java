import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    @Test
    public void validLoginTest() {

        // Automatically download and setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Start browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open test website
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Enter username
        driver.findElement(By.id("username")).sendKeys("student");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("Password123");

        // Click login button
        driver.findElement(By.id("submit")).click();

        // Wait for page to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify login success
        String expectedText = "Logged In Successfully";
        String pageText = driver.getPageSource();

        Assert.assertTrue(pageText.contains(expectedText));

        // Close browser
        driver.quit();
    }
}
