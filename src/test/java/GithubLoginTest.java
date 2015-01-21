
import core.TestBase;
import helpers.*;
import helpers.Actions;
import junit.framework.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.PageObject;

import java.io.IOException;

import static helpers.WebDriverSingleton.getDriver;

@Listeners(CustomListener.class)
public class GithubLoginTest extends TestBase {



    @Test
    public void negativeLoginTest() throws IOException {
        PageObject.login("sfgsgf", "sfssdfsf");
        Actions.takeScreenshot("D:/Students/screen.png");
        Assert.assertTrue(Waiter.waitForElement(getDriver(), PageObject.VALIDATION_MESSAGE).isDisplayed());
        Assert.assertTrue(getDriver().findElement(PageObject.VALIDATION_MESSAGE).isDisplayed());

    }

    @Test
    public void onlinerTest() {
        getDriver().get("http://onliner.by");
        Actions.takeScreenshot("D:/Students/screen.png");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "usersData")
    public void negativeLoginWithDataProviderTest(String value1, String value2){
        PageObject.login(value1, value2);
        Assert.assertTrue(Waiter.waitForElement(getDriver(), PageObject.VALIDATION_MESSAGE).isDisplayed());
    }


    @Test
    public void negativeLoginWithPropertyTest(){
        String[] credentials = Creds.getUser("github.user.admin");
        PageObject.login(credentials[0], credentials[1]);
        Assert.assertTrue(Waiter.waitForElement(getDriver(), PageObject.VALIDATION_MESSAGE).isDisplayed());
    }

}
