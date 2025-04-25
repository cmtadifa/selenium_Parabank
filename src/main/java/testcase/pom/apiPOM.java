package testcase.pom;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import org.openqa.selenium.WebDriver;
import testcase.base.baseAPI;
import static io.restassured.RestAssured.*;

public class apiPOM extends baseAPI {
    //get login get the id
    int customerID;

    // Add this inner class to hold account information
    public static class AccountInfo {
        private int accountId;
        private double balance;

        public AccountInfo(int accountId, double balance) {
            this.accountId = accountId;
            this.balance = balance;
        }

        // Getters
        public int getAccountId() {
            return accountId;
        }

        public double getBalance() {
            return balance;
        }
    }

    public int getCustomer(String userName, String passWord){
        XmlPath xmlPath = given()
//                .header("Content-Type", "application/xml")
//                .header("Accept", "application/xml")
                .pathParam("username", userName)
                .pathParam("password", passWord)
                .when()
                .get("/login/{username}/{password}")
                .then()
                .extract()
                .xmlPath();

        customerID = xmlPath.getInt("customer.id");
        System.out.println("Customer ID: " + customerID);
        return customerID;
    }

    //get customer account and get the account ID
    public AccountInfo getAccountID(int customerID) {
        XmlPath xmlPath = given()
                .pathParam("customerId", customerID)
                .when()
                .get("/customers/{customerId}/accounts")
                .then()
                .extract()
                .xmlPath();

        // Extract the customerId from the JSON response
        int accountID = xmlPath.getInt("accounts.account.id");
        double balance = xmlPath.getDouble("accounts.account.balance");
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: " + balance);
        return new AccountInfo(accountID, balance);
    }

    public double getAccountBalance(String userName, String passWord) {
        // Get customer ID first
        int customerId = getCustomer(userName, passWord);

        // Then get account info and return just the balance
        AccountInfo accountInfo = getAccountID(customerId);
        return accountInfo.getBalance();
    }

}
