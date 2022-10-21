package Jira.StepDefinition_Jira;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Jira.PageElements.ProjectPageElements.menuButton;
import static Jira.PageElements.ProjectTasksPageElements.tasksCounter;
import static com.codeborne.selenide.Condition.visible;

public class ProjectTasksSteps {
    private void openMenu(String menuTitle) {
        menuButton(menuTitle).shouldBe(visible).click();
    }

    @When("^Открываем страницу задач$")
    public void openTasksPage() {
        openMenu("Задачи");
    }

    @Then("^Получаем количество заведенных задач$")
    public static String getCountOfExistsTask() {
        String counter = tasksCounter.shouldBe(visible).getText();
        return tasksCounter.shouldHave(Condition.exactText(counter)).getText().substring("1 из ".length());
    }

}
