package abstractComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Arrays;


public class DriverFactory {

    WebDriver driver;
    public WebDriver initializeDriver() {
        ConfigReader reader = new ConfigReader();
        String driverName = reader.getBrowser();
        if(driverName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }else if(driverName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        driver.get(reader.getURL());
        driver.get(Arrays.toString(reader.getUser()));
        return driver;
    }
}
