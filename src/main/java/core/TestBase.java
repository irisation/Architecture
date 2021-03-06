package core;

import helpers.WebDriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;


public class TestBase {

    protected static final String BASE_URL = "https://github.com/login";

    @BeforeMethod
    public void setup() throws InterruptedException, MalformedURLException {
        String browser = System.getProperty("browser", "firefox");
        WebDriverSingleton.initDriver(browser).get(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        WebDriverSingleton.getDriver().quit();
    }

    //запуск mvn clean -Dbrowser=chrome -Dtest=GithubLoginTest test

}
