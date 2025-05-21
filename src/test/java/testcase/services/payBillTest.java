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

    @Test(description = "Verify All fields are empty")
    public void TCM2() {
        accService = new accountServices(driver);
        api = new apiPOM();
        accountServices.pInfoData data = accService.new pInfoData();
        data.payeeName = "";
        data.street = "";
        data.city = "";
        data.state = "";
        data.zipCode = "";
        data.phone = "";
        data.accno = "";
        data.vaccno = "";
        data.amount = "";

        accService.payeeInfo(data, 0);
        accService.clickSendPayment();
        accService.errorFields("emptyAllFields");
    }

    @Test(description = "Verify invalid values in Account number field")
    public void TCM3() {
        accService = new accountServices(driver);
        api = new apiPOM();
        accountServices.pInfoData data = accService.new pInfoData();
        data.payeeName = fullName;
        data.street = street;
        data.city = city;
        data.state = state;
        data.zipCode = zipcode;
        data.phone = phone;
        data.accno = "this is for testing 123";
        data.vaccno = "this is for testing 123";
        data.amount = "123";

        accService.payeeInfo(data, 0);
        accService.clickSendPayment();
        accService.errorFields("errorInvalidAccNumber");
    }

    @Test(description = "verify account number is not match")
    public void TCM4() {
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
        data.vaccno = "1234";
        data.amount = "123";

        accService.payeeInfo(data, 0);
        accService.clickSendPayment();
        accService.errorFields("errorMismatchAccNumber");
    }

    @Test(description = "Verify invalid values in Amount field")
    public void TCM5() {
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
        data.amount = "this is for testing 123";

        accService.payeeInfo(data, 0);
        accService.clickSendPayment();
        accService.errorFields("errorInvalidAmount");
    }

    @Test(description = "Verify amount cannot be more than account balance", enabled=false) //to enhance
    public void TCM6() {
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
        data.amount = "10000";

        accService.payeeInfo(data, 0);
        accService.clickSendPayment();
    }

    @Test(description = "Verify bill payment with 0 amount", enabled=false)
    public void TCM7() {
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
        data.amount = "0";

        accService.payeeInfo(data, 0);
        accService.clickSendPayment();
    }

    @Test(description = "Verify bill payment with negative amount", enabled=false)
    public void TCM8() {
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
        data.amount = "-123";

        accService.payeeInfo(data, 0);
        accService.clickSendPayment();
    }

    @Test(description = "Verify paying using 2nd account #")
    public void TCM9() {
        accService = new accountServices(driver);
        api = new apiPOM();
        api.postCreateAccount(userName, passWord, "checking");
        accountServices.pInfoData data = accService.new pInfoData();
        data.payeeName = fullName;
        data.street = street;
        data.city = city;
        data.state = state;
        data.zipCode = zipcode;
        data.phone = phone;
        data.accno = "123";
        data.vaccno = "123";
        data.amount = "-123";

        driver.navigate().refresh();
        accService.payeeInfo(data, 1);
        accService.clickSendPayment();
    }

    @Test(description = "Verify multiple bill payments can be made one after another")
    public void TCM10() {
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

        for(int x=0; x<2; x++) {
            String balance = api.getAccountBalance(userName, passWord);
            accService.selectAccountServices("billPay"); // to enhance
            accService.payeeInfo(data, 0);
            accService.clickSendPayment();
            accService.checkBalance(userName, passWord, balance, data);
        }
    }
}




/*

    Verify account balance is updated after bill payment
 */
