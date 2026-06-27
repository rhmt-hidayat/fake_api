package apiTests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class getRequestProduct {
    @BeforeClass
    public void setup() {
        // set base url
        RestAssured.baseURI = "https://api.escuelajs.co";
    }

    @Test
    public void testGetProduct() {
        // get request
        RestAssured
                .given()
                .when()
                .get("/api/v1/products?offset=0&limit=10")
                .then()
                .log()
                .body();
    }

    // Assertion sesuai dengan hasil JSON Schema
    @Test
    public void testGetProductJsonSchema() {
        RestAssured
                .given()
                .when()
                .get("/api/v1/products?offset=0&limit=10")
                .then()
                .assertThat()
                .body(
                    matchesJsonSchemaInClasspath(
                            "azurewebsite/apiTests/platziGetProduct.json"
                    )
                );
    }

    // Assertion GetResponse
    @Test
    public static void getResponseStatus() {
        int statusCode = RestAssured.given().queryParam("limit", 10).when().get("api/v1/products").getStatusCode();

        System.out.println("Status code: " + statusCode);
        RestAssured.given().queryParam("limit", 10).when().get("api/v1/products").then().assertThat().statusCode(200);
    }
}
