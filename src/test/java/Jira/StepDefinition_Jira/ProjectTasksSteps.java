package Jira.StepDefinition_Jira;

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
    public static void getCountOfExistsTask() {
        String taskCounter = tasksCounter.shouldBe(visible).getText();
        System.out.println("Количество заведенных задач: " + taskCounter);
    }

}
