package Jira.PageElements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPageElements {
    public static ElementsCollection tasks = $$x("//*[@class='ghx-issue-content']");
    public static SelenideElement softwareVersion = $x("//span[@id='fixfor-val']");
    public static SelenideElement taskStatus = $x("//span[@id='status-val']");
    public static SelenideElement taskLink = $x("//*[@id='issuekey-val']");
    public static SelenideElement projectTitle = $x(".//*[@class='aui-item project-title']");
    public static SelenideElement projectSidebar = $x(".//*[@class='aui-sidebar-wrapper']");

    public static SelenideElement menuButton(String menuTitle) {
        return $x("//a[contains(@class, 'aui-nav-item')]//*[text()='" + menuTitle + "']").parent();
    }
}
