package StepDefinition_RickAndMorty;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;

import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RickAndMortySteps {
    private static final String BASE_URI = "https://rickandmortyapi.com/api";
    private List<Character> characters;
    private Character mortySmith;
    private Episode lastEpisode;
    private Character lastCharacter;

    @Given("Получаем список персонажей")
    public void getCharacters() {
        characters = given()
                    .filter(new AllureRestAssured())
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                .when()
                    .get("/character")
                .then()
                    .statusCode(200)
                    .log()
                    .all()
                    .extract()
                    .body()
                    .jsonPath()
                    .getList("results", Character.class);
    }

    @When("^Проверяем что в списке есть персонаж (.*)$")
    public void checkCharacterInList(String character) {
        Optional<Character> optionalMortySmith = characters.stream()
                .filter(user -> user.name.matches(character))
                .findFirst();
        assertTrue(optionalMortySmith.isPresent(), "Не нашли юзера Morty Smith");
        mortySmith = optionalMortySmith.get();
        System.out.println(mortySmith);
    }

    @Then("^Получаем последний эпизод с нашим персонажем")
    public void getCharacterLastEpisode() {
        assertFalse(mortySmith.episode.isEmpty(), "У Рика Морти нет эпизодов");
        String lastEpisodeOfMortySmith = mortySmith.episode.get(mortySmith.episode.size() - 1);
        System.out.println(lastEpisodeOfMortySmith);
    }

    @Then("^Получаем последнего персонажа из последнего эпизода нашего персонажа$")
    public void getLastCharacterFromLastEpisodeOfMainCharacter() {
        String lastEpisodeOfMortySmith = mortySmith.episode.get(mortySmith.episode.size() - 1);

        lastEpisode = given()
                    .filter(new AllureRestAssured())
                    .contentType(ContentType.JSON)
                .when()
                    .get(lastEpisodeOfMortySmith)
                .then()
                    .statusCode(200)
                    .log()
                    .all()
                    .extract()
                    .body()
                    .jsonPath()
                    .getObject(".", Episode.class);

        assertFalse(lastEpisode.characters.isEmpty(), "Нет персонажей в эпизоде");
        System.out.println(lastEpisode.characters.get(lastEpisode.characters.size() - 1));
    }

    @Then("^Получаем локацию и расу последнего персонажа из последнего эпизода нашего персонажа и сравниваем$")
    public void getLocationAndRaceOfLastCharacterFromLastEpisodeOfRickMorty() {
        String lastCharacterId = lastEpisode.characters.get(lastEpisode.characters.size() - 1);

        lastCharacter = given()
                    .filter(new AllureRestAssured())
                    .contentType(ContentType.JSON)
                .when()
                    .get(lastCharacterId)
                .then()
                    .statusCode(200)
                    .log()
                    .all()
                    .extract()
                    .body()
                    .jsonPath()
                    .getObject(".", Character.class);

        assertFalse(lastCharacter.location.name.isEmpty(), "Нет данных о местоположении");
        assertFalse(lastCharacter.species.isEmpty(), "Нет данных о расе");

        System.out.println("Местоположение: " + lastCharacter.location.name + " Раса: " + lastCharacter.species);
        String locationAssert = mortySmith.location.name.equals(lastCharacter.location.name) ? "Локация совпадает" : "Локация не совпадает";
        System.out.println(locationAssert);
        String speciesAssert = mortySmith.species.equals(lastCharacter.species) ? "Раса совпадает" : "Раса не совпадает";
        System.out.println(speciesAssert);
    }

        @And("^Проверяем совпадение локации$")
        public void locationAssertCharacters() {
            String locationAssert = mortySmith.location.name.equals(lastCharacter.location.name) ? "Локация совпадает" : "Локация не совпадает";
            System.out.println(locationAssert);
        }

        @And("^Проверяем совпадение расы$")
        public void speciesAssert () {
            String speciesAssert = mortySmith.species.equals(lastCharacter.species) ? "Раса совпадает" : "Раса не совпадает";
            System.out.println(speciesAssert);
        }
    }




