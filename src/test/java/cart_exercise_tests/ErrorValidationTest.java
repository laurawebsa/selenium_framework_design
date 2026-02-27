package cart_exercise_tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectobjects.CartPage;
import projectobjects.ProductCatalog;
import test_components.BaseTest;
import test_components.Retry;

import java.io.IOException;
import java.util.List;

public class ErrorValidationTest extends BaseTest {

        @Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
        public void loginErrorValidation() throws IOException, InterruptedException {
            String productName = "ZARA COAT 3";
            landingPage.loginApplication("laurawebsa@gmail.com", "L*uris1608");
            Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");

        }

    @Test
    public void productErrorValidation() throws IOException, InterruptedException {
        String productName = "ZARA COAT 33";
        ProductCatalog productCatalog = landingPage.
                loginApplication("laurawebsa@gmail.com", "L@uris1608");
        Thread.sleep(5000);
        List<WebElement> products = productCatalog.getProductList();
        productCatalog.addProductToCart(productName);
        CartPage cartPage = productCatalog.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);

        }
}
