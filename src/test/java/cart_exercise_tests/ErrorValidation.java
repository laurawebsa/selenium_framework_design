package cart_exercise_tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectobjects.CartPage;
import projectobjects.CheckoutPage;
import projectobjects.ConfirmationPage;
import projectobjects.LandingPage;
import projectobjects.ProductCatalog;
import test_components.BaseTest;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends BaseTest {

        @Test
        public void submitOrder() throws IOException, InterruptedException {
            String productName = "ZARA COAT 3";
            landingPage.loginApplication("laurawebsa@gmail.com", "L*uris1608");
            Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

        }
}
