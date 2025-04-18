package testcase.pom;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

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



}
