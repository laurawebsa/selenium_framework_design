package testExecution;

import abstractComponents.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.AddToCart;
import pageObjects.LoginPage;
import pageObjects.ProductCatalog;
import utils.ConfigReader;

public class PurchaseEndTest {

    WebDriver driver;
    LoginPage loginPage;
    ConfigReader configReader;
    ProductCatalog productCatalog;
    AddToCart addToCart;


    @BeforeMethod
    public void setUp() {
        configReader = new ConfigReader();
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initializeDriver();
        loginPage = new LoginPage(driver);
        loginPage.goTo(configReader.getURL());
    }

    @Test
    public void endToEndTest(){
      loginPage.userLogin(configReader.getUser()[0],configReader.getUser()[1]);
      productCatalog = new ProductCatalog(driver);
      productCatalog.selectProduct();
      addToCart = new AddToCart(driver);
      addToCart.clickAddToCart();


    }
    @Test(groups = {"incorrectLogin"})
    public void loginIncorrectTest(){
        loginPage.userLogin(configReader.invalidUserPassword()[0],
                configReader.invalidUserPassword()[1]);
        String messageError = loginPage.getErrorMessage();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(messageError, expectedMessage);
    }

}
