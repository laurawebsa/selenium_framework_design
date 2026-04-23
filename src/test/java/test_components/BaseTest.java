package test_components;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import projectobjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landingPage;

    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
                "//src//main//java//resources//GlobalData.properties");
        prop.load(fis);
        String browserName = System.getProperty("browser")!=null ?
                System.getProperty("browser"):prop.getProperty("browser");
        //String browserName = prop.getProperty("browser");

        if(browserName.contains("chrome")) {
            //Headless mode
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            //To set the zoom level in chromedriver as 90%
            if(browserName.contains("headless")) {
                options.addArguments("headless");
            }
            //options.addArguments("--force-device-scale-factor=0.8");
            //options.addArguments("--high-dpi-support=1");
            driver = new ChromeDriver(options);
            //help to run in full screen
            driver.manage().window().setSize(new Dimension(1440,900));

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/lauris/Documents/Selenium");
            driver = new FirefoxDriver();
            //firefox
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //Read JSON to string
        String jsonContent = FileUtils.readFileToString(new File(filePath));

        //String to HashMap with Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir" + "//reports//" + testCaseName + ".png"));
        FileUtils.copyFile(source, file);
        return testCaseName;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {

        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

}
