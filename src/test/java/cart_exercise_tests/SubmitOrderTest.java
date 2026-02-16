package cart_exercise_tests;

import org.testng.annotations.DataProvider;
import projectobjects.OrderPage;
import test_components.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectobjects.CartPage;
import projectobjects.CheckoutPage;
import projectobjects.ConfirmationPage;
import projectobjects.ProductCatalog;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubmitOrderTest  extends BaseTest {
    String productName = "ZARA COAT 3";

        @Test(dataProvider = "getData", groups = {"Purchase"})
        public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {

            ProductCatalog productCatalog = landingPage.
                    loginApplication(input.get("email"), input.get("password"));
            Thread.sleep(5000);
            List<WebElement> products = productCatalog.getProductList();
            productCatalog.addProductToCart(input.get("product"));
            CartPage cartPage = productCatalog.goToCartPage();

            Boolean match = cartPage.verifyProductDisplay(input.get("product"));
            Assert.assertTrue(match);
            cartPage.goToCheckout();
            CheckoutPage checkoutPage = cartPage.goToCheckout();
            checkoutPage.selectCountry("india");
            ConfirmationPage confirmationPage = checkoutPage.submitOrder();
            String confirmMessage = confirmationPage.getConfirmationMessage();
            Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        }

        // To verify if ZARA COAT 3 is displaying in orders page

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest() {
        ProductCatalog productCatalog = landingPage.
                loginApplication("laurawebsa@gmail.com", "Tomodachi1");
        OrderPage ordersPage = productCatalog.goToOrdersPage();
        Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
    }
    @DataProvider
    public Object[][] getData(){
            Map<String,String > map = new HashMap<>();
            map.put("email", "laurawebsa@gmail.com");
            map.put("password", "Tomodachi1");
            map.put("product", "ZARA COAT 3");

            Map<String,String > map1 = new HashMap<>();
            map1.put("email", "laya89@hotmail.com");
            map1.put("password", "Tomodachi1");
            map1.put("product", "iphone 13 pro");

            return new Object[][] {{map},{map1}};
    }
}
