package cart_exercise_tests;

import test_components.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectobjects.CartPage;
import projectobjects.CheckoutPage;
import projectobjects.ConfirmationPage;
import projectobjects.LandingPage;
import projectobjects.ProductCatalog;

import java.io.IOException;
import java.util.List;

public class SubmitOrderTest  extends BaseTest {

        @Test
        public void submitOrder() throws IOException, InterruptedException {
            String productName = "ZARA COAT 3";
            LandingPage landingPage = launchApplication();
            ProductCatalog productCatalog = landingPage.
                    loginApplication("laurawebsa@gmail.com", "L@uris1608");

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
        }
}
