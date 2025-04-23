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
    private By successfullyLoanTxt = By.xpath("//h1[contains(text(),'Loan Request Processed')]");
    //div[@id='loanRequestApproved']/p
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

    public void inputLoanAmount(int loan){
        driver.findElement(loanAmount).sendKeys(String.valueOf(loan));
    }

    public void inputDownPayment(double dpayment){
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
        Assert.assertEquals(text,"Loan Request Processed");
    }

    public void loanTestScenario(int loan, double dpayment, int index){
        inputLoanAmount(loan);
        inputDownPayment(dpayment);
        selectAccountNo(index);
        clickLoanBtn();
        successLoan();
    }



}
