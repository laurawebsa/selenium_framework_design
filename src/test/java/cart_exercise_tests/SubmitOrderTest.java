package cart_exercise_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import projectobjects.CartPage;
import projectobjects.CheckoutPage;
import projectobjects.ConfirmationPage;
import projectobjects.LandingPage;
import projectobjects.ProductCatalog;

import java.time.Duration;
import java.util.List;

public class SubmitOrderTest {

    public static void main(String[] args) throws InterruptedException {

        String productName = "ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Global timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //create an object from LandingPage class
        LandingPage landingPage = new LandingPage(driver);
        //call the methods
        landingPage.goTo();
        ProductCatalog productCatalog =
                landingPage.loginApplication("laurawebsa@gmail.com", "L@uris1608");

        Thread.sleep(5000);
        List<WebElement> products = productCatalog.getProductList();
        productCatalog.addProductToCart(productName);
        CartPage cartPage = productCatalog.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        cartPage.goToCheckout();
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();


        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();


    }
}
