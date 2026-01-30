package projectobjects;

import abstract_components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalog extends AbstractComponent {

    WebDriver driver; //local variable
    //create a constructor that will be the first method to execute
    public ProductCatalog(WebDriver driver) {
        super(driver);
        this.driver = driver;
    //Initializing all elements PageFactory
    PageFactory.initElements(driver, this);
    }

    //PageFactory

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinnerLocator;

    //It's not the driver
    By productsIdLocator = By.cssSelector(".mb-3");
    By toastMessageLocator = By.cssSelector("#toast-container");
    By addToCartLocator = By.cssSelector(".card-body button:last-of-type");
    //wait for the products to appear
    //return to complete list, data prepare
    public List<WebElement> getProductList(){

        waitForElementToAppear(productsIdLocator);
        return products;
    }

    public WebElement getProductByName(String productName){

        WebElement productSearch = getProductList().stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).
                findFirst().orElse(null);
        return productSearch;

    }

    public void addProductToCart(String productName) throws InterruptedException {

        WebElement productSearch = getProductByName(productName);
        productSearch.findElement(addToCartLocator).click();
        waitForElementToAppear(toastMessageLocator);
        waitForElementToDisappear(spinnerLocator);

    }
}
