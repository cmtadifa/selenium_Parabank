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

    @Test(description = "Verify login with invalid credentials")
    public void TCM2() {
        homePage = new homepage(driver);
        accService = new accountServices(driver);

        String userName = "testing!!";
        String passWord = "parabankTest";
        homePage.login(userName, passWord);
        homePage.callbackFunction("invalidCredentials");
    }

    @Test(description = "Verify login with blank username and password")
    public void TCM3() {
        homePage = new homepage(driver);
        accService = new accountServices(driver);

        String userName = "";
        String passWord = "";
        homePage.login(userName, passWord);
        homePage.callbackFunction("blankCredentials");
    }

    @Test(description = "Verify login with only username entered")
    public void TCM4() {
        homePage = new homepage(driver);
        accService = new accountServices(driver);

        String userName = "testing!!";
        String passWord = "";
        homePage.login(userName, passWord);
        homePage.callbackFunction("blankCredentials");
    }

    @Test(description = "Verify login with only password entered\n")
    public void TCM5() {
        homePage = new homepage(driver);
        accService = new accountServices(driver);

        String userName = "";
        String passWord = "parabankTest";
        homePage.login(userName, passWord);
        homePage.callbackFunction("blankCredentials");
    }
}

/*


Verify login with special characters in username
Verify login functionality after logout

 */