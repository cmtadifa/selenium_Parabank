package testcase.accounts;

import jdk.jfr.Description;
import testcase.base.basepage;
import testcase.pom.homepage;
import testcase.utils.config;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class accountRegistrationTest extends basepage {

    @Test(description = "register a valid account")
    public void testExample() {
        homepage homePage = new homepage(driver);

        homePage.clickRegister();
        homePage.fillUpRegFrom();

    }


}
