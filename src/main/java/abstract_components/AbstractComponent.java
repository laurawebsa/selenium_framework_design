package abstract_components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import projectobjects.CartPage;
import projectobjects.OrderPage;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;
    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;

    public void waitForElementToAppear(By FindBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
    }

    public void waitForWebElementToAppear(WebElement FindBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(FindBy));
    }

    public CartPage goToCartPage() {

        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;

    }

    public OrderPage goToOrdersPage() {

        orderHeader.click();
        OrderPage cartPage = new OrderPage(driver);
        return cartPage;

    }

    public void waitForElementToDisappear(WebElement elementLocator) throws InterruptedException {
        Thread.sleep(1000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        //wait.until(ExpectedConditions.invisibilityOf(elementLocator));
    }

}
