package testcase.accounts;

import io.qameta.allure.*;
import testcase.base.basepage;
import testcase.pom.homepage;
import org.testng.annotations.Test;


public class accountRegistrationTest extends basepage {

    @Test(description = "register a valid account")
    public void registration() {
        homepage homePage = new homepage(driver);

        homePage.clickRegister();
        homePage.register();
    }


}
