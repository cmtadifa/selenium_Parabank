package testcase.services;

import org.testng.annotations.Test;
import testcase.pom.accountServices;
import testcase.base.loanbasepage;
import testcase.pom.apiPOM;
import testcase.pom.homepage;

public class loanTest extends loanbasepage {

    accountServices accService;
    apiPOM api;
        @Test(description = "Verify valid loan with down payment less than balance")
        public void TCM1() {
            accService = new accountServices(driver);
            accService.loanTestScenario(100.0,50.0,0, true);
        }

        @Test(description = "Verify Down payment equals balance")
        public void TCM2() {
            accService = new accountServices(driver);
            accService.loanTestScenario(100.0,100.0,0, true);
        }

        @Test(description = "Verify Down payment is zero")
        public void TCM3() {
            accService = new accountServices(driver);
            accService.loanTestScenario(100.0,0.0,0, true);
        }

        @Test(description = "Verify Down payment equals exact balance")
        public void TCM4() {
            accService = new accountServices(driver);
            api = new apiPOM();
            double balance = api.getAccountBalance(userName, passWord);
            accService.loanTestScenario(balance,balance,0, true);
        }

        @Test(description = "Verify Down payment exceeds balance")
        public void TCM5() {
            accService = new accountServices(driver);
            api = new apiPOM();
            double balance = api.getAccountBalance(userName, passWord);
            double excBalance = balance+10;
            accService.loanTestScenario(balance,excBalance,0,false);
        }

        @Test(description = "Verify Down payment equal to loan but exceeds balance")
        public void TCM6() {
            accService = new accountServices(driver);
            api = new apiPOM();
            double balance = api.getAccountBalance(userName, passWord);
            double excBalance = balance+10;
            accService.loanTestScenario(excBalance,excBalance,0,false);
        }
    //
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
