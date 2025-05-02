package testcase.pom;
import com.github.javafaker.Faker;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class homepage {

    private WebDriver driver;
    Faker faker = new Faker();

    private By registerLink =  By.linkText("Register");

    //registration
    private By regFname = By.id("customer.firstName");
    private By regLname = By.id("customer.lastName");
    private By regStreet = By.id("customer.address.street");
    private By regCity = By.id("customer.address.city");
    private By regState = By.id("customer.address.state");
    private By regZipcode = By.id("customer.address.zipCode");
    private By regPhone = By.id("customer.phoneNumber");
    private By regSsn = By.id("customer.ssn");
    private By regUsername = By.id("customer.username");
    private By regPassword = By.id("customer.password");
    private By regConfPassword = By.id("repeatedPassword");
    private By regBtn = By.xpath("//input[@value='Register']");
    private By regSuccessfully = By.className("title");

    private By regFnameError = By.id("customer.firstName.errors");
    private By regLnameError = By.id("customer.lastName.errors");
    private By regAddressError = By.id("customer.address.street.errors");
    private By regCityError = By.id("customer.address.city.errors");
    private By regStateError = By.id("customer.address.state.errors");
    private By regZipCodeError = By.id("customer.address.zipCode.errors");
    private By regSsnError = By.id("customer.ssn.errors");
    private By regUsernameError = By.id("customer.username.errors");
    private By regPasswordError = By.id("customer.password.errors");
    private By regConfPasswordError = By.id("repeatedPassword.errors");

    //login
    private By liUsername = By.xpath("//input[@name='username']");
    private By liPassword =  By.xpath("//input[@name='password']");
    private By liBtm = By.xpath("//input[@value='Log In']");

    //faker
    private String fName = faker.name().firstName();
    private String lName = faker.name().lastName();
    private String street = faker.address().streetAddress();
    private String city = faker.address().city();
    private String state = faker.address().state();
    private String zipCode = faker.address().zipCode();
    private String phone = faker.phoneNumber().phoneNumber();
    private String ssn = faker.idNumber().ssnValid();
    private String userName = "user_" + System.currentTimeMillis();
    private String passWord = "parabankTest";
    private String confPassWord = passWord; // to match password


    public homepage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void register() throws InterruptedException {
        driver.findElement(regFname).sendKeys(fName);
        driver.findElement(regLname).sendKeys(lName);
        driver.findElement(regStreet).sendKeys(street);
        driver.findElement(regCity).sendKeys(city);
        driver.findElement(regState).sendKeys(state);
        driver.findElement(regZipcode).sendKeys(zipCode);
        driver.findElement(regPhone).sendKeys(phone);
        driver.findElement(regSsn).sendKeys(ssn);
        driver.findElement(regUsername).sendKeys(userName);
        System.out.println("Generated username: " + userName);
        driver.findElement(regPassword).sendKeys(passWord);
        driver.findElement(regConfPassword).sendKeys(confPassWord);
            Thread.sleep(1000);

        driver.findElement(regBtn).click();
        Assert.assertEquals(driver.findElement(regSuccessfully).getText(),"Welcome "+userName);

    }

    public void login() {
        driver.findElement(liUsername).sendKeys("admin");
        driver.findElement(liPassword).sendKeys("parabankTest");
        driver.findElement(liBtm).click();
    }


    public class RegistrationData {
        public String fName;
        public String lName;
        public String street;
        public String city;
        public String state;
        public String zipCode;
        public String phone;
        public String ssn;
        public String userName;
        public String passWord;
        public String confPassWord;
        public String expectedResult;
    }
    //Test Suite
    public void registerTest(RegistrationData Data) throws InterruptedException {
        driver.findElement(regFname).sendKeys(Data.fName != null ? Data.fName : fName);
        driver.findElement(regLname).sendKeys(Data.lName != null ? Data.lName : lName);
        driver.findElement(regStreet).sendKeys(Data.street != null ? Data.street : street);
        driver.findElement(regCity).sendKeys(Data.city != null ? Data.city : city);
        driver.findElement(regState).sendKeys(Data.state != null ? Data.state : state);
        driver.findElement(regZipcode).sendKeys(Data.zipCode != null ? Data.zipCode : zipCode);
        driver.findElement(regPhone).sendKeys(Data.phone != null ? Data.phone : phone);
        driver.findElement(regSsn).sendKeys(Data.ssn != null ? Data.ssn : ssn);
        driver.findElement(regUsername).sendKeys(Data.userName != null ? Data.userName : userName);
        driver.findElement(regPassword).sendKeys(Data.passWord != null ? Data.passWord : passWord);
        driver.findElement(regConfPassword).sendKeys(Data.confPassWord != null ? Data.confPassWord : confPassWord);
        Thread.sleep(1000);

        driver.findElement(regBtn).click();
        switch (Data.expectedResult) {
            case "success":
                Assert.assertEquals(driver.findElement(regSuccessfully).getText(),"Welcome "+Data.userName);
                break;
            case "requiredFields":
                Assert.assertTrue(driver.findElement(regFnameError).isDisplayed(), "First name is required.");
                Assert.assertTrue(driver.findElement(regLnameError).isDisplayed(), "Last name is required.");
                Assert.assertTrue(driver.findElement(regAddressError).isDisplayed(), "Address is required.");
                Assert.assertTrue(driver.findElement(regCityError).isDisplayed(), "City is required.");
                Assert.assertTrue(driver.findElement(regStateError).isDisplayed(), "State is required.");
                Assert.assertTrue(driver.findElement(regZipCodeError).isDisplayed(), "Zip Code is required.");
                Assert.assertTrue(driver.findElement(regSsnError).isDisplayed(), "Social Security Number is required.");
                Assert.assertTrue(driver.findElement(regUsernameError).isDisplayed(), "Username is required.");
                Assert.assertTrue(driver.findElement(regPasswordError).isDisplayed(), "Password is required.");
                Assert.assertTrue(driver.findElement(regConfPasswordError).isDisplayed(), "Password confirmation is required.");
                break;
            case "passMismatch":
                Assert.assertTrue(driver.findElement(regConfPasswordError).isDisplayed(), "Passwords did not match.");
                Assert.assertEquals(driver.findElement(regConfPasswordError).getText(),"Passwords did not match.");
                break;
            case "zipcode":
                Assert.assertTrue(driver.findElement(regZipCodeError).isDisplayed(), "ZIP code is invalid.");
                Assert.assertEquals(driver.findElement(regSsnError).getText(),"ZIP code is invalid.");
                break;
            case "ssn":
                Assert.assertTrue(driver.findElement(regSsnError).isDisplayed(), "Ssn is invalid.");
                Assert.assertEquals(driver.findElement(regSsnError).getText(),"Ssn is invalid.");
                break;
            case "userNameExist":
                Assert.assertTrue(driver.findElement(regUsernameError).isDisplayed(), "This username already exists.");
                Assert.assertEquals(driver.findElement(regUsernameError).getText(),"This username already exists.");
                break;
            case "userNameInvalid":
                Assert.assertTrue(driver.findElement(regUsernameError).isDisplayed(), "Invalid Username.");
                Assert.assertEquals(driver.findElement(regUsernameError).getText(),"Invalid Username.");
                break;
            case "userNameMissing":
                Assert.assertTrue(driver.findElement(regUsernameError).isDisplayed(), "Username is required.");
                Assert.assertEquals(driver.findElement(regUsernameError).getText(),"Username is required.");
                break;

        }

    }

}
