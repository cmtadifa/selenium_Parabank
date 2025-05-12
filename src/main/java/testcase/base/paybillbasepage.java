package testcase.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testcase.pom.accountServices;
import testcase.pom.homepage;
import testcase.utils.config;

import java.time.Duration;

public class paybillbasepage {
    protected WebDriver driver;
    public String fullName, street, city, state, zipcode, phone, userName, passWord;
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
        this.fullName = homePage.getfName()+" "+homePage.getlName();
        this.street = homePage.getStreet();
        this.city = homePage.getCity();
        this.state = homePage.getState();
        this.zipcode = homePage.getZipCode();
        this.phone = homePage.getPhone();

        accService.selectAccountServices("billPay");
    }

//    @AfterMethod
//    public void tearDown() {
//        // Close the browser after each test
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}

