package azurewebsite.apiTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class getRequestPage {
    @BeforeClass
    public void setup() {
        // set base url
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void testGetUser() {
        // get request
        RestAssured
            .given()
            .when()
            .get("/api/users?page=2")
            .then()
            .log()
            .body();
    }

    // jika pakai params
    @Test
    public void testGetUserWithParams() {
        // get request
        RestAssured
            .given()
            .queryParam("page", "2")
            .when()
            .get("/api/users")
            .then()
            .log()
            .body();
    }

    // Assertion GetResponse
    @Test
    public static void getResponseStatus() {
        int statusCode = RestAssured.given().queryParam("page", 2).when().get("api/users").getStatusCode();

        System.out.println("Status code: " + statusCode);
        RestAssured.given().queryParam("page", 2).when().get("api/users").then().assertThat().statusCode(401);
    }
}
