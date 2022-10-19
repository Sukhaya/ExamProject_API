package Jira.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskPageElements {
    public static SelenideElement toDoButton = $x(".//*[@id='action_id_11']");
    public static SelenideElement inProgressButton = $x(".//*[@id='action_id_21']");
    public static SelenideElement resolvedButton = $x("//*[@class='issueaction-workflow-transition']//*[text()='Выполнено']");
    public static SelenideElement workFlowButton = $x("//*[@id='opsbar-transitions_more']");
    public static SelenideElement statusField = $x("//*[@id='status-val']");
    public static SelenideElement notificationPopup = $x("//*[@id='aui-flag-container']");
    public static SelenideElement closeNotificationButton = $x("//*[@class='aui-close-button']");
}
