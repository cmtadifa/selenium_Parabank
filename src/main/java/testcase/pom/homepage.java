package testcase.pom;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

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
    String randomNo = faker.number().digits(4);
    private String userName = fName+lName+randomNo;
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

    public void register() {
        driver.findElement(regFname).sendKeys(fName);
        driver.findElement(regLname).sendKeys(lName);
        driver.findElement(regStreet).sendKeys(street);
        driver.findElement(regCity).sendKeys(city);
        driver.findElement(regState).sendKeys(state);
        driver.findElement(regZipcode).sendKeys(zipCode);
        driver.findElement(regPhone).sendKeys(phone);
        driver.findElement(regSsn).sendKeys(ssn);
        driver.findElement(regUsername).sendKeys(userName);
        driver.findElement(regPassword).sendKeys(passWord);
        driver.findElement(regConfPassword).sendKeys(confPassWord);
        driver.findElement(regBtn).click();
        Assert.assertEquals(driver.findElement(regSuccessfully).getText(),"Welcome "+userName);
        System.out.println(userName);
    }

    public void login() {
        driver.findElement(liUsername).sendKeys("admin");
        driver.findElement(liPassword).sendKeys("parabankTest");
        driver.findElement(liBtm).click();
    }

}
