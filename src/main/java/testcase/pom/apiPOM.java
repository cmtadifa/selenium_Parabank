package testcase.pom;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import testcase.base.baseAPI;

import static io.restassured.RestAssured.*;

public class apiPOM extends baseAPI {
    //get login get the id
    //get customer account and get the customer ID
    public int getCustomerID(int accountID) {
        JsonPath jsonPath = given()
                .pathParam("accountId", accountID)
                .when()
                .get("/accounts/{accountId}") // Replace with your endpoint
                .jsonPath();

        // Extract the customerId from the JSON response
        int customerId = jsonPath.getInt("customerId");

        return customerId; // Return the extracted customerId
    }

}
