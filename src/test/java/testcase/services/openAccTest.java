package testcase.services;
import org.testng.annotations.Test;
import testcase.base.openaccbasepage;
import testcase.pom.accountServices;
import testcase.pom.apiPOM;
import testcase.pom.homepage;


public class openAccTest extends openaccbasepage {
    accountServices accService;
    homepage homePage;
    apiPOM api;

    @Test(description = "Verify opening a Checking account with valid amount")
    public void TCM1() {
        homePage = new homepage(driver);
        api = new apiPOM();
    //register
    //go to open account
    //check balance should be greater than the minimum value
    //input valid amount and create amd assert successfully
    //check the first account deducted balance and put it to newly account

    }
    /*

    Verify opening a Checking account with exact required amount
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