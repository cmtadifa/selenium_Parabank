package testcase.base;

import io.restassured.RestAssured;

public class baseAPI {
    protected String BASE_URL = "https://parabank.parasoft.com/parabank/services/bank";

    public baseAPI() {
        RestAssured.baseURI = BASE_URL;
    }
}