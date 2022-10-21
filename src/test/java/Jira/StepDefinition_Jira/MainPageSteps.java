package Jira.StepDefinition_Jira;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Jira.PageElements.MainPageElements.projectsMenu;
import static Jira.PageElements.MainPageElements.testTESTProject;
import static Jira.PageElements.ProjectPageElements.projectSidebar;
import static Jira.PageElements.ProjectPageElements.projectTitle;
import static Utils.Configuration.getConfigurationValue;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPageSteps {

    @When("^Открываем список проектов$")
    public void openMenuOfProjects() {
        projectsMenu.shouldBe(visible).click();
    }

    @When("^Переходим в проект TestProject$")
    public void openTestProject() {
        testTESTProject.should(appear).click();
    }

    @When("^Получаем название текущего открытого проекта$")
    public  String getProjectTitle() {
        return projectTitle.shouldBe(exist).innerText();
    }

    @When("^Проверяем появилась ли боковая панель проекта$")
    public  boolean isProjectSidebarAppears() {
        return projectSidebar.is(appear);
    }

    @Then("^Проверяем, что находимся в нужном проекте$")
            public void checkCurrentProject() {
        assertEquals(getConfigurationValue("PROJECT"), getProjectTitle());
    }
}
