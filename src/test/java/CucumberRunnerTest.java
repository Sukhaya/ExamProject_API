
import Hook.WebHooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
        "html:target/cucumber-html-reports",
        "json:target/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"Hook",
                "StepDefinition_RickAndMorty",
                "StepDefinition_reqRes"},
        tags = "@TEST"
)
public class CucumberRunnerTest extends WebHooks {
}


