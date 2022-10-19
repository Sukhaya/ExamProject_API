package Jira.StepDefinition_Jira;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Jira.PageElements.ProjectPageElements.taskLink;
import static Jira.PageElements.TaskPageElements.closeNotificationButton;
import static Jira.PageElements.TaskPageElements.inProgressButton;
import static Jira.PageElements.TaskPageElements.notificationPopup;
import static Jira.PageElements.TaskPageElements.resolvedButton;
import static Jira.PageElements.TaskPageElements.statusField;
import static Jira.PageElements.TaskPageElements.toDoButton;
import static Jira.PageElements.TaskPageElements.workFlowButton;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class TaskSteps {
    @When("^Открываем страницу текущей задачи$")
    public void openTaskPage() {
        taskLink.shouldBe(visible).click();
    }

    @When("Меняем статус задачи - Нужно сделать")
    public void changeStatusTodo() {
        toDoButton.shouldBe(visible).click();
        notificationPopup.should(appear);
        closeNotificationButton.shouldBe(visible).click();
    }

    @When("Меняем статус задачи - В работе")
    public void changeStatusInProgress() {
        inProgressButton.shouldBe(visible).click();
        notificationPopup.should(appear);
        closeNotificationButton.shouldBe(visible).click();
    }

    @When("Меняем статус задачи - Выполнено")
    public void changeStatusResolved() {
        workFlowButton.shouldBe(visible).click();
        resolvedButton.shouldBe(visible).click();
        notificationPopup.should(appear);
        closeNotificationButton.shouldBe(visible).click();
    }

    @Then("^Проверяем смену статуса (.*)$")
    public void checkTaskStatus(String taskStatus) {
        statusField.shouldHave(text(taskStatus));
    }

}
