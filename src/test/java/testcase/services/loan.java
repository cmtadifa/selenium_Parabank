package testcase.services;

import io.qameta.allure.*;
import testcase.base.baseE2Epage;
import testcase.pom.accountServices;
import testcase.pom.homepage;
import org.testng.annotations.Test;
import testcase.pom.apiPOM;


public class loan extends baseE2Epage {
    private String userName;
    @Test(description = "Register")
    public void navigate() {
        homepage homePage = new homepage(driver);

        homePage.clickRegister();
        homePage.register();
        userName = homePage.getUserName();
    }

    @Test(description = "testing", dependsOnMethods = "navigate")
    public void getCustomerID() {
        apiPOM api = new apiPOM();
        homepage homePage = new homepage(driver);
        String passWord = homePage.getPassWord();
        api.getCustomer(userName,passWord);
    }


//    @Test(description = "request a loan")
//    public void request_loan() {
//        accountServices accService = new accountServices(driver);
//        accService.selectAccountServices("reqLoan");
//    }


}
