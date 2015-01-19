package helpers;


import org.openqa.selenium.By;

import java.io.InputStream;
import java.util.Properties;

public class Locators {
    private static final Properties LOCATORS;

    private enum LocatorType{
        id, name, css, xpath, tag, text, partText
    }

    static {
        LOCATORS = new Properties();
        try {
            InputStream is = Locators.class.getResourceAsStream("/Locators.properties");
            LOCATORS.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static By get(String elementName) {
        String[] locatorItems = LOCATORS.getProperty(elementName).split("=", 2);
        LocatorType locatorType = LocatorType.valueOf(locatorItems[0]);
        
        switch (locatorType) {
            case css: {
                return By.cssSelector(locatorItems[1]);
            }
            case name: {
                return By.name(locatorItems[1]);
            }
            case id: {
                return By.id(locatorItems[1]);
            }
            case xpath: {
                return By.xpath(locatorItems[1]);
            }
            case tag: {
                return By.tagName(locatorItems[1]);
            }
            case text: {
                return By.linkText(locatorItems[1]);
            }
            case partText: {
                return By.partialLinkText(locatorItems[1]);
            }
            default: {
                throw new IllegalArgumentException("Type " + locatorItems[0] + " is not supported");
            }
        }
    }
}
