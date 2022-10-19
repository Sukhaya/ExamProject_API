package Jira.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateTaskPageElements {
    public static SelenideElement issueTypeDropdown = $x("//*[@id='issuetype-single-select']//input");
    public static SelenideElement issueSummaryInput = $x("//*[@id='summary']");
    public static SelenideElement issueDescriptionTogglerToText = $x("//*[@data-mode='source']");
    public static SelenideElement issueDescriptionInput = $x("//*[@id='description-wiki-edit']//textarea");
    public static SelenideElement createIssueSubmitButton = $x("//*[@id='create-issue-submit']");
}
