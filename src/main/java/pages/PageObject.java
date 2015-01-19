package pages;


import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Locators.get;

public class PageObject {
    private static final By USER_NAME_FIELD = get("loginPage.userNameField");
    private static final By PASSWORD_FIELD = get("loginPage.passwordField");
    private static final By LOGIN_BUTTON = get("loginPage.loginButton");

    public static void login(WebDriver driver, String user, String pass) {
        driver.findElement(USER_NAME_FIELD).clear();
        driver.findElement(USER_NAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(pass);
        driver.findElement(LOGIN_BUTTON).click();
    }

}
