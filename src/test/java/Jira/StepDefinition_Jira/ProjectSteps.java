package Jira.StepDefinition_Jira;



import io.cucumber.java.en.When;

import static Jira.PageElements.ProjectPageElements.menuButton;
import static Jira.PageElements.ProjectPageElements.softwareVersion;
import static Jira.PageElements.ProjectPageElements.taskStatus;
import static Jira.PageElements.ProjectPageElements.tasks;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class ProjectSteps {
    private void openMenu(String menuTitle) {
        menuButton(menuTitle).shouldBe(visible).click();
    }

    @When("^Открываем страницу списка задач$")
    public void openIssuesPage() {
        openMenu("Список задач");
    }

    @When("^Переходим в задачу (.*)$")
    public static void openTask(String taskName) {
        tasks.filter(text(taskName)).shouldHave(sizeGreaterThan(0)).first().click();
    }

    @When("^Проверяем статус задачи и выводим привязку к версии$")
    public void checkStatusAndVersion() {
        String svText = softwareVersion.shouldBe(visible).getText();
        String taskStatusText = taskStatus.shouldBe(visible).getText();
        System.out.println("Software version: " + svText + "\nTask status: " + taskStatusText);
    }
}
