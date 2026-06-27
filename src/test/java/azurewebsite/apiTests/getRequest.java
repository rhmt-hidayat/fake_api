package apiTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class getRequest {
    @BeforeClass
    public void setup() {
        // set base url
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }

    @Test
    public void testGetUser() {
        // get request
        RestAssured.given()
            .when()
            .get("/users/1")
            .then()
            .statusCode(200);
    }

    @Test
    public static void getResponseStatus() {
        int statusCode = RestAssured.given().when().get("/users/1").getStatusCode();
        System.out.println("Status code: " + statusCode);
    }
}
