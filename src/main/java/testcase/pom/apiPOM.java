package testcase.pom;

import io.restassured.path.xml.XmlPath;
import testcase.base.baseAPI;
import static io.restassured.RestAssured.*;

public class apiPOM extends baseAPI {
    //get login get the id
    int customerID;

    // Add this inner class to hold account information
    public static class AccountInfo {
        private String accountId;
        private String balance;

        public AccountInfo(String accountId, String balance) {
            this.accountId = accountId;
            this.balance = balance;
        }

        // Getters
        public String getAccountId() {
            return accountId;
        }

        public String getBalance() {
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
        String accountID = xmlPath.getString("accounts.account.id");
        String balance = xmlPath.getString("accounts.account.balance");
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: " + balance);
        return new AccountInfo(accountID, balance);
    }

    //create Account
    public int postCreatenewAccount(int customerID, int accountType, int fromAccountId) {
        XmlPath xmlPath = given()
            .queryParam("customerId", customerID)
            .queryParam("newAccountType", accountType)
            .queryParam("fromAccountId", fromAccountId)
        .when()
            .post("/createAccount")
        .then()
            .statusCode(200)
            .extract()
            .xmlPath();

        int newAccountId = xmlPath.getInt("account.id");
        System.out.println("New Account ID: " + newAccountId);

        return newAccountId;
    }

/* --------------------------------------------------------------------------------- */

    public String postCreateAccount(String userName, String passWord, String accType) {
        // Get customer ID first
        int customerID = getCustomer(userName, passWord);
        AccountInfo accountID = getAccountID(customerID);
        int accountType = 0;
            switch (accType.toLowerCase()) {
                case "checking":
                    accountType = 0;
                    break;
                case "savings":
                    accountType = 1;
                    break;
                case "loan":
                    accountType = 2;
                    break;
            }

        int fromAccountId = Integer.parseInt(accountID.getAccountId());
        int newAccount = postCreatenewAccount(customerID, accountType, fromAccountId);
        return String.valueOf(newAccount);
    }

    public String getAccountBalance(String userName, String passWord) {
        // Get customer ID first
        int customerId = getCustomer(userName, passWord);

        // Then get account info and return just the balance
        AccountInfo accountInfo = getAccountID(customerId);
        return accountInfo.getBalance();
    }

}
