
import Hook.WebHooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
        "html:target/cucumber-html-reports",
        "json:target/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"Hook",
                "Jira.StepDefinition_Jira",
                "StepDefinition_RickAndMorty",
                "StepDefinition_reqRes"}
)
public class CucumberRunnerTest extends WebHooks {
    @BeforeClass
    public static void before() {
        RestAssured.filters(new AllureRestAssured());
    }
}


