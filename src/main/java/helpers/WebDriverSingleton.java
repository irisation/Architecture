package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            return new FirefoxDriver();
        }
    }

    public static WebDriver initDriver(String browser) throws MalformedURLException {
        switch (browser) {
            case "firefox": {
//                driver = new RemoteWebDriver(DesiredCapabilities.firefox());
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("firefox");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
                break;
            }
            case "chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "ie": {
                driver = new InternetExplorerDriver();
                break;
            }
            case "htmlunit": {
                driver = new HtmlUnitDriver();
                break;
            }

            case "phantomjs": {
                driver = new PhantomJSDriver();
                break;
            }
            default: {
                driver = new FirefoxDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        return driver;
    }
}
