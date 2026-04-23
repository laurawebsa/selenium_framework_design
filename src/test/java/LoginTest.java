import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.ConfigReader;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    ConfigReader configReader;

    @BeforeMethod
    public void setUp() {
        configReader = new ConfigReader();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.goTo(configReader.getURL());
    }

    @Test
    public void loginTest(){
      loginPage.userLogin(configReader.getUser()[0],configReader.getUser()[1]);
    }
    @Test
    public void loginIncorrectTest(){
        loginPage.userLogin(configReader.invalidUserPassword()[0],
                configReader.invalidUserPassword()[1]);
        String messageError = loginPage.getErrorMessage();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(messageError, expectedMessage);
    }
}
