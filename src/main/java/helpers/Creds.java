package helpers;

import org.openqa.selenium.By;

import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class Creds {
    private static final Properties CREDENTIALS;
    static {
        CREDENTIALS = new Properties();
        try {
            InputStream is = Creds.class.getResourceAsStream("/Credentials.properties");
            CREDENTIALS.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static String[] getUser(String role) {
        String[] credentials = CREDENTIALS.getProperty(role).split(",");
        return credentials;
    }

}
