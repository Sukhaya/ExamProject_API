package Jira.StepDefinition_Jira;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Jira.PageElements.CreateTaskPageElements.createIssueSubmitButton;
import static Jira.PageElements.CreateTaskPageElements.issueDescriptionInput;
import static Jira.PageElements.CreateTaskPageElements.issueDescriptionTogglerToText;
import static Jira.PageElements.CreateTaskPageElements.issueSummaryInput;
import static Jira.PageElements.CreateTaskPageElements.issueTypeDropdown;
import static Jira.PageElements.MainPageElements.createTaskButton;
import static Jira.PageElements.MainPageElements.messageSuccess;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class CreateTaskSteps {
    @When("^Переходим к созданию задачи$")
    public void openCreateTask() {
        createTaskButton.shouldBe(visible).click();
    }

    @When("^Установим для задачи тип (.*)$")
    public void setType(String type) {
        issueTypeDropdown.shouldBe(visible).setValue(type).pressEnter();
    }

    @When("^Установим для задачи тему (.*)$")
    public void setSummary(String theme) {
        issueSummaryInput.shouldBe(visible).setValue(theme);
    }

    @When("^Установим для задачи описание(.*)$")
    public void setDescription(String description) {
        issueDescriptionTogglerToText.shouldBe(exist).click();
        issueDescriptionInput.shouldBe(exist).sendKeys(description);
    }

    @When("^Подтверждаем создание задачи$")
    public void clickAccept() {
        createIssueSubmitButton.shouldBe(visible).click();
    }

    @Then("^Получаем текст сообщения об успешном создании таски$")
    public  String getSuccessMessageText() {
        return messageSuccess.shouldBe(appear).getText();
    }
}

