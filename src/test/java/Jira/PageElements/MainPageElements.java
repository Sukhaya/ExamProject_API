package Jira.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPageElements {
    public static SelenideElement userProfileIcon = $x("//a[@id='header-details-user-fullname']");
    public static SelenideElement projectsMenu = $x("//a[@href='/browse/TEST']");
    public static SelenideElement testTESTProject = $x("//*[contains(text(), 'Test (TEST)')]");
    public static SelenideElement createTaskButton = $x("//*[@id='create_link']");
    public static SelenideElement messageSuccess = $x("//*[contains(@class, 'aui-message-success')]");
}
