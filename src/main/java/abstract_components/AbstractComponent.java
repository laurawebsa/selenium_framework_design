package abstract_components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import projectobjects.CartPage;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;
    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    public void waitForElementToAppear(By FindBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
    }

    public CartPage goToCartPage() {

        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;

    }

    public void waitForElementToDisappear(WebElement elementLocator) throws InterruptedException {
        Thread.sleep(1000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        //wait.until(ExpectedConditions.invisibilityOf(elementLocator));
    }

}
