package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;


import static helpers.WebDriverSingleton.getDriver;


public class Actions {
    public static void takeScreenshot(String path) {
        try {
            TakesScreenshot shooter = (TakesScreenshot) getDriver();
            File screen = shooter.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screen, new File(path));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
