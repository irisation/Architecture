package core;

import helpers.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class TestBase {
    protected WebDriver driver;
    protected static final String BASE_URL = "https://github.com/login";

    @BeforeMethod
    public void setup() throws InterruptedException {
        String browser = System.getProperty("browser", "phantomjs");
        WebDriverSingleton.initDriver(browser).get(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        WebDriverSingleton.getDriver().quit();
    }

    //запуск mvn clean -Dbrowser=chrome -Dtest=GithubLoginTest test

}
