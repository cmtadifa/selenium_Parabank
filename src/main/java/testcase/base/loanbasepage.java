package testcase.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testcase.pom.accountServices;
import testcase.pom.homepage;
import testcase.utils.config;

import java.time.Duration;

public class loanbasepage {
    protected WebDriver driver;
    public String userName;
    public String passWord;
    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(config.BASE_URL);

        homepage homePage = new homepage(driver);
        accountServices accService = new accountServices(driver);
        homePage.clickRegister();
        homePage.register();

        this.userName = homePage.getUserName();
        this.passWord = homePage.getPassWord();

        accService.selectAccountServices("reqLoan");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}

