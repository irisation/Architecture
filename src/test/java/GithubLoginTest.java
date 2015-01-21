import core.TestBase;
import helpers.Creds;
import helpers.DataProviders;
import helpers.Waiter;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PageObject;

public class GithubLoginTest extends TestBase {
    private PageObject page;

    @Override
    @BeforeMethod
    public void setup() throws InterruptedException {
        super.setup();
        page = new PageObject(driver);

    }

    @Test
    public void negativeLoginTest() {
        page.login(driver, "sfgsgf", "sfssdfsf");
        Assert.assertTrue(Waiter.waitForElement(driver, PageObject.VALIDATION_MESSAGE).isDisplayed());
        Assert.assertTrue(driver.findElement(PageObject.VALIDATION_MESSAGE).isDisplayed());

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "usersData")
    public void negativeLoginWithDataProviderTest(String value1, String value2){
        page.login(driver, value1, value2);
        Assert.assertTrue(Waiter.waitForElement(driver, PageObject.VALIDATION_MESSAGE).isDisplayed());
    }


    @Test
    public void negativeLoginWithPropertyTest(){
        String[] credentials = Creds.getUser("github.user.admin");
        page.login(driver, credentials[0], credentials[1]);
        Assert.assertTrue(Waiter.waitForElement(driver, PageObject.VALIDATION_MESSAGE).isDisplayed());
    }

}
