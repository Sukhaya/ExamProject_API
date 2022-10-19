package Jira.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectTasksPageElements {
    public static SelenideElement tasksCounter = $x("//*[@class='showing']");
}
