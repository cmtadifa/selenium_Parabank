package testcase.accounts;

import testcase.base.basepage;
import testcase.pom.homepage;
import testcase.utils.config;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class accountRegistrationTest extends basepage {

    @Test
    public void testExample() {
        homepage homePage = new homepage(driver);

        homePage.clickRegister();
        homePage.fillUpRegFrom();

    }


}
