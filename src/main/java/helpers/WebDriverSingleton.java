package helpers;

import org.openqa.selenium.Platform;
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
        String remote = System.getProperty("remote", "");
        if (remote.length() > 0) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (browser) {
                case "firefox": {
//                driver = new RemoteWebDriver(DesiredCapabilities.firefox());
//                  DesiredCapabilities capabilities = new DesiredCapabilities("firefox", "29", Platform.VISTA);


//                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
                    capabilities.setBrowserName("firefox");
//                capabilities.setVersion("29");
                    break;
                }
                case "chrome": {

                    capabilities.setBrowserName("chrome");
                    break;
                }
                case "ie": {
                    capabilities.setBrowserName("internet explorer");
                    break;
                }
                case "htmlunit": {
                    capabilities.setBrowserName("htmlunit");
                    break;
                }

                case "phantomjs": {
                    capabilities.setBrowserName("phantomjs");
                    break;
                }
                default: {
                    capabilities.setBrowserName("firefox");
                }
            }
            driver = new RemoteWebDriver(new URL(remote), capabilities);
        } else {
            switch (browser) {
                case "firefox": {
                    driver = new FirefoxDriver();
                    break;
                }
                case "chrome": {
                    driver = new ChromeDriver();
                    break;
                }
                case "ie": {
                    driver = new HtmlUnitDriver();
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
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        return driver;
    }
}
