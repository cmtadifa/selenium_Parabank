package testcase.pom;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class accountServices {
    private WebDriver driver;
    Faker faker = new Faker();

    private By newAccLink = By.linkText("Open New Account");
    private By accOverviewLink = By.linkText("Accounts Overview");
    private By transferFundsLink = By.linkText("Transfer Funds");
    private By billPayLink = By.linkText("Bill Pay");
    private By findTransacLink = By.linkText("Find Transactions");
    private By updateContactInfoLink = By.linkText("Update Contact Info");
    private By reqLoanLink = By.linkText("Request Loan");
    private By logOutLink = By.linkText("Log Out");

    private By loanAmount = By.xpath("//input[@id='amount']");
    private By loanDownAmount = By.xpath("//input[@id='downPayment']");
    private By loanAccountNo = By.xpath("//select[@id='fromAccountId']");
    private By loanApplyBtn = By.xpath("//input[@value='Apply Now']");
    private By successfullyLoanTxt = By.xpath("//p[contains(text(),'Congratulations, your loan has been approved.')]");
    private By failLoanTxt = By.xpath("//p[contains(text(),'You do not have sufficient funds for the given')]");
    private By errorTxt = By.xpath("//p[contains(text(),'An internal error has occurred and has been logged.')]");

    //billpay
    private By billPayeeName = By.xpath("//input[@name='payee.name']");
    private By billAddress = By.xpath("//input[@name='payee.address.street']");
    private By billCity = By.xpath("//input[@name='payee.address.city']");
    private By billState = By.xpath("//input[@name='payee.address.state']");
    private By billZipCode = By.xpath("//input[@name='payee.address.zipCode']");
    private By billPhoneNo = By.xpath("//input[@name='payee.phoneNumber']");
    private By billAccountNo = By.xpath("//input[@name='payee.accountNumber']");
    private By billVAccountNo = By.xpath("//input[@name='verifyAccount']");
    private By billAmount = By.xpath("//input[@name='amount']");
    private By billPayAccountNo = By.xpath("//select[@name='fromAccountId']");
    private By sendPaymentBtn = By.xpath("//input[@value='Send Payment']");

    private By billErrorEmptyPayee = By.id("validationModel-name");
    private By billErrorEmptyAddress = By.id("validationModel-address");
    private By billErrorEmptyCity = By.id("validationModel-city");
    private By billErrorEmptyState = By.id("validationModel-state");
    private By billErrorEmptyZipcode = By.id("validationModel-zipCode");
    private By billErrorEmptyPhone = By.id("validationModel-phoneNumber");
    private By billErrorEmptyAcc = By.id("validationModel-account-empty");
    private By billErrorInvalidAcc = By.id("validationModel-account-invalid");
    private By billErrorEmptyVAcc = By.id("validationModel-verifyAccount-empty");
    private By billErrorInvalidVAcc = By.id("validationModel-verifyAccount-invalid");
    private By billErrorMismatchVAcc = By.id("validationModel-verifyAccount-mismatch");
    private By billErrorEmptyAmount = By.id("validationModel-amount-empty");
    private By billErrorInvalidAmount = By.id("validationModel-amount-invalid");

    //open acc
    private By openAccBtn = By.xpath("//input[@type='button']");
    private By typeAcc = By.id("type");
    private By successfullyOpenAccTxt = By.xpath("//p[contains(text(),'Congratulations, your account is now open.')]");

    public accountServices(WebDriver driver) {
        this.driver = driver;
    }

    public void selectAccountServices(String accServices) {
        switch (accServices) {
            case "newAccount":
                driver.findElement(newAccLink).click();
                break;
            case "accOverview":
                driver.findElement(accOverviewLink).click();
                break;
            case "transferFunds":
                driver.findElement(transferFundsLink).click();
                break;
            case "billPay":
                driver.findElement(billPayLink).click();
                break;
            case "findTransaction":
                driver.findElement(findTransacLink).click();
                break;
            case "updateContactInfo":
                driver.findElement(updateContactInfoLink).click();
                break;
            case "reqLoan":
                driver.findElement(reqLoanLink).click();
                break;
            case "logOut":
                driver.findElement(logOutLink).click();
                break;
        }
    }

    public void inputLoanAmount(String loan){
        driver.findElement(loanAmount).sendKeys(String.valueOf(loan));
    }

    public void inputDownPayment(String dpayment){
        driver.findElement(loanDownAmount).sendKeys(String.valueOf(dpayment));
    }

    public void selectAccountNo(int index){
        WebElement dropdown = driver.findElement(loanAccountNo);
        Select accNoDropdown = new Select(dropdown);
        accNoDropdown.selectByIndex(index);
    }

    public void clickLoanBtn(){
        driver.findElement(loanApplyBtn).click();
    }

    public void successLoan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(successfullyLoanTxt));
        String text = element.getText();
        Assert.assertEquals(text,"Congratulations, your loan has been approved.");
    }

    public void failedLoan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(failLoanTxt));
        String text = element.getText();
        Assert.assertEquals(text,"You do not have sufficient funds for the given down payment.");
    }

    public void error() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(errorTxt));
        String text = element.getText();
        Assert.assertEquals(text,"An internal error has occurred and has been logged.");
    }

    public void loanTestScenario(String loan, String dpayment, int index, String status ){
        inputLoanAmount(loan);
        inputDownPayment(dpayment);
        selectAccountNo(index);
        clickLoanBtn();
        switch (status) {
            case "success":
                successLoan();
                break;
            case "failed":
                failedLoan();
                break;
            case "error":
                error();
                break;
        }
    }

    //bill pay
    public void selectBillccountNo(int index){
        WebElement dropdown = driver.findElement(billPayAccountNo);
        Select accNoDropdown = new Select(dropdown);
        accNoDropdown.selectByIndex(index);
    }

    public class pInfoData {
        public String payeeName;
        public String street;
        public String city;
        public String state;
        public String zipCode;
        public String phone;
        public String accno;
        public String vaccno;
        public String amount = "100";
    }

    public void payeeInfo(pInfoData Data, int index) {
        driver.findElement(billPayeeName).sendKeys(Data.payeeName);
        driver.findElement(billAddress).sendKeys(Data.street);
        driver.findElement(billCity).sendKeys(Data.city);
        driver.findElement(billState).sendKeys(Data.state);
        driver.findElement(billZipCode).sendKeys(Data.zipCode);
        driver.findElement(billPhoneNo).sendKeys(Data.phone);
        driver.findElement(billAccountNo).sendKeys(Data.accno);
        driver.findElement(billVAccountNo).sendKeys(Data.vaccno);

        driver.findElement(billAmount).sendKeys(Data.amount);

        selectBillccountNo(index);
    }

    public void clickSendPayment() {
        driver.findElement(sendPaymentBtn).click();
    }

    public void checkBalance(String userName, String passWord, String oldBal, pInfoData Data) {
        apiPOM api;
        api = new apiPOM();

        double balance = Double.parseDouble(api.getAccountBalance(userName, passWord));
        double oldBalance = Double.parseDouble(oldBal);
        double amount = Double.parseDouble(Data.amount);
        double fBalance = oldBalance - amount;
        Assert.assertEquals(balance, fBalance);
    }

    public void errorFields(String error){
        switch (error) {
            case "emptyAllFields":
                Assert.assertTrue(driver.findElement(billErrorEmptyPayee).isDisplayed(), "Payee name is required.");
                Assert.assertTrue(driver.findElement(billErrorEmptyAddress).isDisplayed(), "Address is required.");
                Assert.assertTrue(driver.findElement(billErrorEmptyCity).isDisplayed(), "City is required.");
                Assert.assertTrue(driver.findElement(billErrorEmptyState).isDisplayed(), "State is required.");
                Assert.assertTrue(driver.findElement(billErrorEmptyZipcode).isDisplayed(), "Zip Code is required.");
                Assert.assertTrue(driver.findElement(billErrorEmptyPhone).isDisplayed(), "Phone number is required.");
                Assert.assertTrue(driver.findElement(billErrorEmptyAcc).isDisplayed(), "Account number is required.");
                Assert.assertTrue(driver.findElement(billErrorEmptyVAcc).isDisplayed(), "Account number is required.");
                Assert.assertTrue(driver.findElement(billErrorEmptyAmount).isDisplayed(), "The amount cannot be empty.");
                break;
            case "errorInvalidAmount":
                Assert.assertTrue(driver.findElement(billErrorInvalidAmount).isDisplayed(), "Please enter a valid amount");
                break;
            case "errorInvalidAccNumber":
                Assert.assertTrue(driver.findElement(billErrorInvalidAcc).isDisplayed(), "Please enter a valid number.");
                Assert.assertTrue(driver.findElement(billErrorInvalidVAcc).isDisplayed(), "Please enter a valid number.");
                break;
            case "errorMismatchAccNumber":
                Assert.assertTrue(driver.findElement(billErrorMismatchVAcc).isDisplayed(), "The account numbers do not match.");
                break;

        }
    }

    //open acc
    public void checkAcc(String balance, double minimum) {
        double Dbalance = Double.parseDouble(balance);
        Assert.assertTrue(Dbalance >= minimum, "Balance is not greater than minimum");
    }

    public void selectTypeAcc (String accountType ) {
        WebElement typeAccDropDown = driver.findElement(typeAcc);

        Select select = new Select(typeAccDropDown);

        String accType = accountType.toUpperCase();
        select.selectByVisibleText(accType);
    }

    public void clickOpenAccBtn () {
        driver.findElement(openAccBtn).click();
    }

    public void successOpenAccTxt() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(successfullyOpenAccTxt));
        String successTxt = element.getText();
        Assert.assertEquals(successTxt, "Congratulations, your account is now open.");
    }

}
