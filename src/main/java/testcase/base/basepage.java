package testcase.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import testcase.utils.config;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class basepage {
    protected WebDriver driver;
    protected WebDriver wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.BASE_URL);
    }

//    @AfterClass
//    public void tearDown() {
//        // Close the browser after each test
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
