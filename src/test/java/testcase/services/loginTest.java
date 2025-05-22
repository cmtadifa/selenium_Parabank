package testcase.services;
import org.testng.annotations.Test;
import testcase.base.basepage;
import testcase.pom.accountServices;
import testcase.pom.apiPOM;
import testcase.pom.homepage;


public class loginTest extends basepage{
    accountServices accService;
    apiPOM api;
    homepage homePage;
    @Test(description = "Verify successful login with valid credentials")
    public void TCM1() throws InterruptedException {
        homePage = new homepage(driver);
        accService = new accountServices(driver);

        homePage.clickRegister();
        homePage.register();
        accService.selectAccountServices("logOut");
        String userName = homePage.getUserName();
        String passWord = homePage.getPassWord();
        homePage.login(userName, passWord);
        homePage.successfullyLogin();
    }

}

/*
Verify login with invalid username
Verify login with invalid password
Verify login with both username and password incorrect
Verify login with blank username and password
Verify login with only username entered
Verify login with only password entered
Verify login with special characters in username
Verify login functionality after logout

 */