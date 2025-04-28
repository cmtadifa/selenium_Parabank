package testcase.accounts;

import testcase.base.basepage;
import testcase.pom.homepage;
import org.testng.annotations.Test;


public class accountRegistration extends basepage {

    @Test(description = "register a valid account")
    public void registration() throws InterruptedException {
        homepage homePage = new homepage(driver);

        homePage.clickRegister();
        homePage.register();
    }
}
