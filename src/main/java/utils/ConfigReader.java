package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    public ConfigReader() {
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream
                (System.getProperty("user.dir") + "/src/test/resources/config.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getURL() {return prop.getProperty("url"); }
    public String getBrowser(){
        return prop.getProperty("browser");
    }

    public String[] getUser(){
        return new String[]{prop.getProperty("username")
                ,prop.getProperty("password")};
    }

    public String[] invalidUserPassword(){
        return new String[]{prop.getProperty("invalidUsername"),
                prop.getProperty("invalidPassword")};
    }
}
