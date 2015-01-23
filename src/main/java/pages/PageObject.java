package pages;


import core.PageBase;
import org.openqa.selenium.By;
import static helpers.Locators.get;
import static helpers.WebDriverSingleton.getDriver;

public class PageObject extends PageBase {
    private static final By USER_NAME_FIELD = get("loginPage.userNameField");
    private static final By PASSWORD_FIELD = get("loginPage.passwordField");
    private static final By LOGIN_BUTTON = get("loginPage.loginButton");
    private static final By REMEMBER_CHECKBOX = get("loginPage.rememberCheckbox.temp", "value");
    public static final By VALIDATION_MESSAGE = get("loginPage.validationMessage");


    public static void login(String user, String pass) {
        getDriver().findElement(USER_NAME_FIELD).clear();
        getDriver().findElement(USER_NAME_FIELD).sendKeys(user);
        getDriver().findElement(PASSWORD_FIELD).clear();
        getDriver().findElement(PASSWORD_FIELD).sendKeys(pass);
        getDriver().findElement(LOGIN_BUTTON).click();
    }

}
