package testcase.pom;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import org.openqa.selenium.WebDriver;
import testcase.base.baseAPI;
import static io.restassured.RestAssured.*;

public class apiPOM extends baseAPI {
    //get login get the id
    int customerID;
    public int getCustomer(String userName, String passWord){
        XmlPath xmlPath = given()
                .header("Content-Type", "application/xml")
                .header("Accept", "application/xml")
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
    //get customer account and get the customer ID
    public int getCustomerID(int accountID) {
        JsonPath jsonPath = given()
                .pathParam("accountId", accountID)
                .when()
                .get("/accounts/{accountId}")
                .jsonPath();

        // Extract the customerId from the JSON response
        int customerId = jsonPath.getInt("customerId");

        return customerId; // Return the extracted customerId
    }

}
