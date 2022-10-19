package Jira.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPageElements {
    public static SelenideElement loginField = $x("//input[@id='login-form-username']");
    public static SelenideElement passwordField = $x("//input[@id='login-form-password']");
    public static SelenideElement loginButton = $x("//input[@id='login']");
}