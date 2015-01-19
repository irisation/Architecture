import core.TestBase;
import helpers.Waiter;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
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
        page = new PageObject(driver);
        page.login(driver, "sfgsgf", "sfssdfsf");
        Assert.assertTrue(Waiter.waitForElement(driver, PageObject.VALIDATION_MESSAGE).isDisplayed());
        Assert.assertTrue(driver.findElement(PageObject.VALIDATION_MESSAGE).isDisplayed());

    }
}
