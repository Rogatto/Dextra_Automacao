package utilities;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ExtractJsonMockaroo {

    public static String host = "https://my.api.mockaroo.com/dextraautomacao?key=1c5af660";

    public static Response jsonMockaroo() {

        Response response =
                given()
                        .when()
                        .get(host)
                        .then()
                        .statusCode(200)
                        .extract().
                        response();

        System.out.println(response.asString());

        return response;
    }

}