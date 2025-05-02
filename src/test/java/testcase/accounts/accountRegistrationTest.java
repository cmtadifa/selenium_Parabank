package testcase.accounts;

import org.testng.annotations.BeforeMethod;
import testcase.base.basepage;
import testcase.pom.homepage;
import org.testng.annotations.Test;

public class accountRegistrationTest extends basepage {

    @BeforeMethod
    public void clickRegister() {
        homepage homePage = new homepage(driver);

        homePage.clickRegister();
    }

    @Test(description = "Verify successful registration with valid inputs")
    public void TCM1() throws InterruptedException {
        homepage homePage = new homepage(driver);
        homepage.RegistrationData data = homePage.new RegistrationData();
        data.fName = "John";
        data.lName = "Doe";
        data.zipCode = "12345";
        data.ssn = "123-45-678";
        data.phone = "123456789";
        data.userName = "parabank21";
        data.passWord = "password123";
        data.confPassWord = "password123";
        data.expectedResult = "success";

        homePage.registerTest(data);
    }

    @Test(description = "Verify registration with missing required fields")
    public void TCM2() throws InterruptedException {
        homepage homePage = new homepage(driver);
        homepage.RegistrationData data = homePage.new RegistrationData();
        data.fName = "";
        data.lName = "";
        data.street = "";
        data.city = "";
        data.state = "";
        data.zipCode = "";
        data.ssn = "";
        data.phone = "";
        data.userName = "";
        data.passWord = "";
        data.confPassWord = "";
        data.expectedResult = "requiredFields";

        homePage.registerTest(data);
    }

    @Test(description = "Verify password and confirm password mismatch")
    public void TCM3() throws InterruptedException {
        homepage homePage = new homepage(driver);
        homepage.RegistrationData data = homePage.new RegistrationData();
        data.confPassWord = "parabankTest1";
        data.expectedResult = "passMismatch";

        homePage.registerTest(data);
    }

    @Test(description = "Verify Zip Code field with invalid data") //failed due to existing issue on error field
    public void TCM4() throws InterruptedException {
        homepage homePage = new homepage(driver);
        homepage.RegistrationData data = homePage.new RegistrationData();
        data.zipCode = "-!@#4para$@bank";
        data.expectedResult = "zipcode";

        homePage.registerTest(data);
    }

    @Test(description = "Verify SSN field with invalid format") //failed due to existing issue on error field
    public void TCM5() throws InterruptedException {
        homepage homePage = new homepage(driver);
        homepage.RegistrationData data = homePage.new RegistrationData();
        data.ssn = "@randomSSn123";
        data.expectedResult = "ssn";

        homePage.registerTest(data);
    }

    @Test(description = "Verify phone number field with invalid input") //Invalid due to existing issue on no restriction
    public void TCM6() throws InterruptedException {
        homepage homePage = new homepage(driver);
        homepage.RegistrationData data = homePage.new RegistrationData();
        data.phone = "randomnumber0123";
        data.expectedResult = "";

        homePage.registerTest(data);
    }

    @Test(description = "Verify registration with existing username") //need to manually create account for this, since the page is public and can clear all the created account
    public void TCM7() throws InterruptedException {
        homepage homePage = new homepage(driver);
        homepage.RegistrationData data = homePage.new RegistrationData();
        data.userName = "admin";
        data.expectedResult = "userNameExist";

        homePage.registerTest(data);
    }

    @Test(description = "Verify username field accepts alphanumeric only") //failed due to existing issue on no restriction
    public void TCM8() throws InterruptedException {
        homepage homePage = new homepage(driver);
        homepage.RegistrationData data = homePage.new RegistrationData();
        data.userName = "admin123!@#$%";
        data.expectedResult = "userNameInvalid";

        homePage.registerTest(data);
    }

    @Test(description = "Verify form with blank username fields")
    public void TCM9() throws InterruptedException {
        homepage homePage = new homepage(driver);
        homepage.RegistrationData data = homePage.new RegistrationData();
        data.userName = "";
        data.expectedResult = "userNameMissing";

        homePage.registerTest(data);
    }

    @Test(description = "Verify form with blank password fields")
    public void TCM10() throws InterruptedException {
        homepage homePage = new homepage(driver);
        homepage.RegistrationData data = homePage.new RegistrationData();
        data.passWord = "";
        data.expectedResult = "passWordMissing";

        homePage.registerTest(data);
    }

    @Test(description = "Verify form with blank Confirm password fields")
    public void TCM11() throws InterruptedException {
        homepage homePage = new homepage(driver);
        homepage.RegistrationData data = homePage.new RegistrationData();
        data.confPassWord = "";
        data.expectedResult = "confPassWordMissing";

        homePage.registerTest(data);
    }

    @Test(description = "Verify field limits for Username field") //should be failed due to wrong username error
    public void TCM12() throws InterruptedException {
        homepage homePage = new homepage(driver);
        homepage.RegistrationData data = homePage.new RegistrationData();
        data.userName = "Pneumonoultramicroscopicsilicovolcanoconiosis";
        data.expectedResult = "userNameInvalid";

        homePage.registerTest(data);
    }
    /*


    Verify registration with special characters in address fields
    Verify form reset behavior
    Check tab order navigation
     */

}
