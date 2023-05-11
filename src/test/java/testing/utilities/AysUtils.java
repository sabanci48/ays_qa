package testing.utilities;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class AysUtils {

    /*
    @Test
    void test1() {
      String  requestBody ="{\n" +
              "    \"username\": \"232180\",\n" +
              "    \"password\": \"367894\"\n" +
              "}";

        //System.out.println(generateToken(requestBody));

        System.out.println("generateToken(requestBody) = " + generateToken(requestBody));

    }

     */

// buraya token almak icin bir code yazilabilir.

    public static String generateToken(String requestBodyJson) {


        JsonPath jsonPath = given().accept(ContentType.JSON).log().body()
                .and()
                .contentType("application/json")
                .body(requestBodyJson)
                .when()
                .post(ConfigurationReader.getProperty("APIURL") +"/api/v1/authentication/token").jsonPath();


        String token = jsonPath.getString("response.accessToken");

        return token;
    }


}
