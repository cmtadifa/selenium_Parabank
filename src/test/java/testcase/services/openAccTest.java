package testcase.services;
import org.testng.annotations.Test;
import testcase.base.basepage;
import testcase.pom.accountServices;
import testcase.pom.apiPOM;
import testcase.pom.homepage;


public class openAccTest extends basepage {
    accountServices accService;
    homepage homePage;
    apiPOM api;

    @Test(description = "Verify opening a Checking account with valid amount")
    public void TCM1() throws InterruptedException {
        homePage = new homepage(driver);
        api = new apiPOM();;
        accService = new accountServices(driver);

        homePage.selectPanelServices("adminPage");
        double initial = 1000;
        double minimum = 100;
        homePage.setBalance(initial,minimum);
        homePage.clickRegister();
        homePage.register();

        String userName = homePage.getUserName();
        String passWord = homePage.getPassWord();

        accService.selectAccountServices("newAccount");
        String accBal = api.getAccountBalance(userName, passWord);
        accService.checkAcc(accBal, minimum);
        accService.clickOpenAccBtn();
        accService.successOpenAccTxt();
    }

    @Test(description = "Verify opening a Checking account with exact required amount")
    public void TCM2() throws InterruptedException {
        homePage = new homepage(driver);
        api = new apiPOM();;
        accService = new accountServices(driver);

        homePage.selectPanelServices("adminPage");
        double initial = 100;
        double minimum = 100;
        homePage.setBalance(initial,minimum);
        homePage.clickRegister();
        homePage.register();

        String userName = homePage.getUserName();
        String passWord = homePage.getPassWord();

        accService.selectAccountServices("newAccount");
        String accBal = api.getAccountBalance(userName, passWord);
        accService.checkAcc(accBal, minimum);
        accService.clickOpenAccBtn();
        accService.successOpenAccTxt();
    }

    @Test(description = "Verify opening a Checking account with blank amount field")
    public void TCM3() throws InterruptedException {
        homePage = new homepage(driver);
        api = new apiPOM();;
        accService = new accountServices(driver);

        homePage.selectPanelServices("adminPage");
        double initial = 100;
        double minimum = 0;
        homePage.setBalance(initial,minimum);
        homePage.clickRegister();
        homePage.register();

        String userName = homePage.getUserName();
        String passWord = homePage.getPassWord();

        accService.selectAccountServices("newAccount");
        String accBal = api.getAccountBalance(userName, passWord);
        accService.checkAcc(accBal, minimum);
        accService.clickOpenAccBtn();
        accService.successOpenAccTxt();
    }

    /*
    Verify opening a Checking account with blank amount field
    Verify opening a Checking account with alphanumeric amount
    Verify opening a Checking account with less than the required amount
    Verify opening a Savings account with valid amount
    Verify opening a Savings account with exact required amount
    Verify opening a Savings account with blank amount field
    Verify opening a Savings account with alphanumeric amount
    Verify opening a Savings account with less than the required amount
    Verify opening a Savings and Checking account using the first account
    Verify opening a new account using the other opened account
    Verify account dropdown with 3 opened account to be the same  with the accounts overview
     */

}