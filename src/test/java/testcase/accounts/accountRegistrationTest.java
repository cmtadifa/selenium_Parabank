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
    public void registration() throws InterruptedException {
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

    /*

    Verify registration with missing required fields
    Verify password and confirm password mismatch
    Verify Zip Code field with invalid data
    Verify SSN field with invalid format
    Verify phone number field with invalid input
    Verify registration with existing username
    Verify username field accepts alphanumeric only
    Verify form with blank password fields
    Verify field limits for input fields
    Verify registration with special characters in address fields
    Verify form reset behavior
    Check tab order navigation
     */

}
