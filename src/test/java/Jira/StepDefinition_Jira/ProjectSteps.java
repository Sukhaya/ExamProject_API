package Jira.StepDefinition_Jira;

import io.cucumber.java.en.When;


import static Jira.PageElements.ProjectPageElements.menuButton;
import static Jira.PageElements.ProjectPageElements.softwareVersion;
import static Jira.PageElements.ProjectPageElements.taskLink;
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
    public static void openTask(String taskTitle) {
        tasks.filter(text(taskTitle)).shouldHave(sizeGreaterThan(0)).first().click();
    }

    @When("Открываем страницу задачи")
    public static void openTaskPage() {
        taskLink.shouldBe(visible).click();
    }


    @When("^Проверяем статус задачи$")
    public static String checkStatus() {
        return taskStatus.shouldBe(visible).getText();
    }

    @When("^Проверяем привязку к версии$")
    public static String checkVersion() {
        return softwareVersion.shouldBe(visible).getText();
    }
}
