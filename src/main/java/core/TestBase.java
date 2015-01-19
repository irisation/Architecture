package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class TestBase {
    protected WebDriver driver;
    protected static final String BASE_URL = "https://github.com/login";

    @BeforeMethod
    public void setup() throws InterruptedException {
        String browser = System.getProperty("browser", "firefox");
        driver = initDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    //запуск mvn clean -Dbrowser=chrome test
    private WebDriver initDriver(String browser) {
        switch (browser) {
            case "firefox" : {
                return new FirefoxDriver();
            }
            case "chrome" : {
                return new ChromeDriver();
            }
            case "ie" : {
                return new InternetExplorerDriver();
            }
            default: {
                return new FirefoxDriver();
            }
        }
    }
}
