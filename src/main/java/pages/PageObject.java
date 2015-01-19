package pages;


import core.PageBase;
import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Locators.get;

public class PageObject extends PageBase {
    private final By USER_NAME_FIELD = get("loginPage.userNameField");
    private final By PASSWORD_FIELD = get("loginPage.passwordField");
    private final By LOGIN_BUTTON = get("loginPage.loginButton");
    private final By REMEMBER_CHECKBOX = get("loginPage.rememberCheckbox.temp", "value");
    public static final By VALIDATION_MESSAGE = get("loginPage.validationMessage");


    public PageObject(WebDriver driver) {
        super(driver);
    }

    public void login(WebDriver driver, String user, String pass) {
        driver.findElement(USER_NAME_FIELD).clear();
        driver.findElement(USER_NAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(pass);
        driver.findElement(LOGIN_BUTTON).click();
    }

}
