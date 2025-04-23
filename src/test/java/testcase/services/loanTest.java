package testcase.services;

import org.testng.annotations.Test;
import testcase.pom.accountServices;
import testcase.base.loanbasepage;

    public class loanTest extends loanbasepage {

        accountServices accService;
        @Test(description = "Verify valid loan with down payment less than balance")
        public void TCM1() {
            accService = new accountServices(driver);
            accService.loanTestScenario(100,50,0);
        }

    //Verify Down payment equals balance
    //Verify Down payment is zero
    //Verify Loan amount is small, affordable down payment
    //Verify Down payment equals exact balance
    //Verify Loan amount very low, down payment equals it but within balance
    //Verify Down payment exceeds balance
    //Verify Down payment equal to loan but exceeds balance
    //Verify Down payment is negative
    //Verify Down payment contains characters
    //Verify Loan amount is missing
    //Verify Down payment is missing
    //Verify Down payment of $201 (over the balance)
    //Verify Loan amount zero


/*
    @Test(description = "testing", dependsOnMethods = "navigate")
    public void getCustomerID() {
        apiPOM api = new apiPOM();
        homepage homePage = new homepage(driver);
        String passWord = homePage.getPassWord();
        int customerId = api.getCustomer(userName, passWord);
        apiPOM.AccountInfo accountInfo = api.getAccountID(customerId);
        int accountId = accountInfo.getAccountId();
        double balance = accountInfo.getBalance();

    } */





}
