package testcase.services;

import io.qameta.allure.*;
import testcase.base.baseE2Epage;
import testcase.pom.accountServices;
import testcase.pom.homepage;
import org.testng.annotations.Test;



public class loan extends baseE2Epage {

    @Test(description = "navigatre")
    public void navigate() {
        homepage homePage = new homepage(driver);

        homePage.clickRegister();
        homePage.register();
    }

    @Test(description = "request a loan")
    public void request_loan() {
        accountServices accService = new accountServices(driver);
        accService.selectAccountServices("reqLoan");
    }


}
