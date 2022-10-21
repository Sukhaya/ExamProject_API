package StepDefinition_RickAndMorty;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static Utils.Configuration.getConfigurationValue;
import static io.restassured.RestAssured.given;

public class RickAndMortySteps {

    public String characterId;
    public String mortyLocation;
    public String mortyRace;
    public int lastEpisode;
    public int lastCharacter;
    public String lastCharactersRace;
    public String lastCharactersLocation;


    @Given("^Получаем информацию по персонажу$")
    public void getCharacter(String id) {
        Response character = given()
                    .filter(new AllureRestAssured())
                    .baseUri(getConfigurationValue("BASE_URI"))
                    .contentType(ContentType.JSON)
                .when()
                    .get("/character/" + id)
                .then()
                    .statusCode(200)
                    .log()
                    .all()
                    .extract()
                    .response();
        characterId = new JSONObject(character.getBody().asString()).get("id").toString();
        mortyLocation = new JSONObject(character.getBody().asString()).getJSONObject("location").get("name").toString();
        mortyRace = new JSONObject(character.getBody().asString()).get("species").toString();
    }

    @Then("^Получаем последний эпизод с нашим персонажем")
    public void getCharacterLastEpisode() {
        Response getLastEpisode = given()
                    .filter(new AllureRestAssured())
                    .baseUri(getConfigurationValue("BASE_URI"))
                    .contentType(ContentType.JSON)
                .when()
                    .get("/character/" + characterId)
                .then()
                    .statusCode(200)
                    .log()
                    .all()
                    .extract()
                    .response();
        int episode = (new JSONObject(getLastEpisode.getBody().asString()).getJSONArray("episode").length() - 1);
        lastEpisode = Integer.parseInt(new JSONObject(getLastEpisode.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", ""));
    }


    @Then("^Получаем последнего персонажа из последнего эпизода нашего персонажа$")
    public void getLastCharacterFromLastEpisodeOfMainCharacter() {
        Response lastCharacterFromLastEpisodeOfMainCharacter = given()
                    .filter(new AllureRestAssured())
                    .baseUri(getConfigurationValue("BASE_URI"))
                    .contentType(ContentType.JSON)
                .when()
                    .get("/episode/" + lastEpisode)
                .then()
                    .statusCode(200)
                    .log()
                    .all()
                    .extract()
                    .response();
        int lastCharacterIndex = (new JSONObject(lastCharacterFromLastEpisodeOfMainCharacter.getBody().asString())
                .getJSONArray("characters").length() - 1);
        lastCharacter = Integer.parseInt(new JSONObject(lastCharacterFromLastEpisodeOfMainCharacter.getBody().asString())
                .getJSONArray("characters").get(lastCharacterIndex).toString().replaceAll("[^0-9]", ""));
    }


        @Then("^Получаем локацию и расу последнего персонажа из последнего эпизода нашего персонажа и сравниваем$")
        public void getLocationAndRaceOfLastCharacterFromLastEpisodeOfRickMorty () {
            Response locationAndRaceOfLastCharacterFromLastEpisodeOfRickMorty = given()
                        .filter(new AllureRestAssured())
                        .baseUri(getConfigurationValue("BASE_URI"))
                        .contentType(ContentType.JSON)
                    .when()
                        .get("/character/" + lastCharacter)
                    .then()
                        .statusCode(200)
                        .log()
                        .all()
                        .extract()
                        .response();

            lastCharactersRace = new JSONObject(locationAndRaceOfLastCharacterFromLastEpisodeOfRickMorty.getBody().asString()).get("species").toString();
            lastCharactersLocation = new JSONObject(locationAndRaceOfLastCharacterFromLastEpisodeOfRickMorty.getBody().asString())
                    .getJSONObject("location").get("name").toString();
        }

        @And("^Проверяем совпадение локации$")
        public void locationAssert() {
            Assertions.assertEquals(mortyLocation, lastCharactersLocation, "Не совпадает");
        }

        @And("^Проверяем совпадение расы$")
        public void raceAssert() {
            Assertions.assertEquals(mortyRace, lastCharactersRace, "Не совпадает");
        }
    }




