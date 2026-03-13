package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import projectobjects.CartPage;
import projectobjects.CheckoutPage;
import projectobjects.ConfirmationPage;
import projectobjects.LandingPage;
import projectobjects.ProductCatalog;
import test_components.BaseTest;

import java.io.IOException;
import java.util.List;

public class StepDefinitionImpl extends BaseTest {
    public LandingPage landingPage;
    public ProductCatalog productCatalog;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void i_landed_on_Ecommerce_Page() throws IOException {

        landingPage = launchApplication();
    }
    // Use regular expressions to describe username and password
    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password(String username, String password) throws IOException {

        productCatalog = landingPage.loginApplication(username, password);
    }

    @When("^I add product (.+) to Cart$")
    public void i_add_product_to_Cart(String productName) throws IOException {
        List<WebElement> products = productCatalog.getProductList();
        productCatalog.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String productName) throws IOException {

        CartPage cartPage = productCatalog.goToCartPage();
        Boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        confirmationPage = checkoutPage.submitOrder();
    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_ConfirmationPage(String string) throws IOException {
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));

    }

    @Then("^\"([^\"]*)\" message is displayed$")
    public void message_displayed(String stringA) throws IOException {
        Assert.assertEquals(landingPage.getErrorMessage(), stringA);
    }

}
