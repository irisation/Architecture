package core;

import org.openqa.selenium.WebDriver;

/**
 * Created by Admin on 19.01.2015.
 */
public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }
}
