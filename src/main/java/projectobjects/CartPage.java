package projectobjects;

import abstract_components.AbstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.cartProducts = cartProducts;
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyProductDisplay(String productName) {
        return cartProducts.stream().anyMatch(product -> product.getText().
                equalsIgnoreCase(productName));
    }

    public CheckoutPage goToCheckout() {
        //checkoutEle.click();
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", checkoutEle);
        return new CheckoutPage(driver);*/
        waitForElementToBeClickable(checkoutEle);
        checkoutEle.click();
        return new CheckoutPage(driver);
    }
}
