package StepDefinition_reqRes;

import io.cucumber.java.en.When;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReqResTest {
    private static final String CREATE_USER = "/users";
    private static final String BASE_URI = "https://reqres.in/api";

    @When("^Отправляем запрос и получаем ответ на соответствие$")
    public void createUser() throws IOException {
        File jsonFile = new File("src/main/resources/user.json");
        JSONObject json = new JSONObject(new String(Files.readAllBytes(jsonFile.toPath())));
        json.remove("name");
        json = json.put("name", "Tomato").put("job", "Eat market");


        HashMap<String, String> responseJson = given()
                    .filter(new AllureRestAssured())
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .body(json.toString())
                .when()
                    .post(CREATE_USER)
                .then()
                    .statusCode(201)
                    .extract()
                    .body()
                    .jsonPath()
                    .get();

        assertEquals("Tomato", responseJson.get("name"));
        assertEquals("Eat market", responseJson.get("job"));
        assertTrue(responseJson.containsKey("id"));
        assertFalse(responseJson.get("id").isEmpty());
        assertTrue(responseJson.containsKey("createdAt"));
        assertFalse(responseJson.get("createdAt").isEmpty());
    }

}
