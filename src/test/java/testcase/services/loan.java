package testcase.services;

import io.qameta.allure.*;
import testcase.base.baseE2Epage;
import testcase.pom.accountServices;
import testcase.pom.homepage;
import org.testng.annotations.Test;
import testcase.pom.apiPOM;


public class loan extends baseE2Epage {
    private String userName, passWord;
    @Test(description = "Register")
    public void navigate() {
        homepage homePage = new homepage(driver);

        homePage.clickRegister();
        homePage.register();
        userName = homePage.getUserName();
        passWord = homePage.getPassWord();
    }

    @Test(description = "testing", dependsOnMethods = "navigate")
    public void getCustomerID() {

        apiPOM api = new apiPOM();

        // Just one line to get the balance
        double balance = api.getAccountBalance(userName, passWord);

        // Now use the balance as needed
        System.out.println("Account balance: " + balance);
    }


    @Test(description = "request a loan")
    public void request_loan() {
        accountServices accService = new accountServices(driver);
        accService.selectAccountServices("reqLoan");

    }


}
