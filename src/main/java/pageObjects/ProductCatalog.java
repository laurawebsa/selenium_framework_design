package pageObjects;

import abstractComponents.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalog  extends BasePage {
    WebDriver driver;


    public ProductCatalog(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#add-to-cart-sauce-labs-bike-light")
    WebElement firstProduct;
    @FindBy (css = "#add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement secondProduct;


    public AddToCart selectProduct() {
        firstProduct.click();
        secondProduct.click();
        return new AddToCart(driver);
    }
}
