package testcase.services;
import org.testng.annotations.Test;
import testcase.base.paybillbasepage;
import testcase.pom.accountServices;
import testcase.pom.apiPOM;
import testcase.pom.homepage;


public class payBillTest extends paybillbasepage{

    accountServices accService;
    apiPOM api;
    @Test(description = "Verify successful bill payment with all valid data")
    public void TCM1() {
        accService = new accountServices(driver);
        api = new apiPOM();
        accountServices.pInfoData data = accService.new pInfoData();
        data.payeeName = fullName;
        data.street = street;
        data.city = city;
        data.state = state;
        data.zipCode = zipcode;
        data.phone = phone;
        data.accno = "123";
        data.vaccno = "123";
        data.amount = "123";

        String balance = api.getAccountBalance(userName, passWord);

        accService.payeeInfo(data, 0);
        accService.clickSendPayment();
        accService.checkBalance(userName, passWord, balance, data);
    }

    @Test(description = "Verify bill payment fails when amount fields are left empty")
    public void TCM2() {
        accService = new accountServices(driver);
        api = new apiPOM();
        accountServices.pInfoData data = accService.new pInfoData();
        data.payeeName = fullName;
        data.street = street;
        data.city = city;
        data.state = state;
        data.zipCode = zipcode;
        data.phone = phone;
        data.accno = "123";
        data.vaccno = "123";
        data.amount = "";

        accService.payeeInfo(data, 0);
        accService.clickSendPayment();
        accService.emptyField();
    }
}

/*


    Verify that only numeric values are allowed in “Amount” field
    Verify proper format validation for zip code
    Verify successful payment to loan account
    Verify amount cannot be more than account balance
    Verify bill payment with amount = 0
    Verify negative amount is not allowed
    Verify valid characters are required in name & address fields
    Verify successful payment updates transaction history
    Verify dropdown (if any) selects a valid “From Account”
    Verify UI formatting for currency in amount
    Verify success message after payment
    Verify multiple bill payments can be made one after another
    Verify account balance is updated after bill payment
 */
