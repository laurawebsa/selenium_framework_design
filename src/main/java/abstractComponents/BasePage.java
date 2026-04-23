package abstractComponents;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (css = "h3[data-test='error']")
    WebElement errorMessage;

    public String getErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public void clickAddProduct(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void dismissPasswordPopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
            WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable
                    (By.xpath("//*[text()='OK']")));
            clickAddProduct(okBtn);
            System.out.println("popup closed");
        } catch (Exception e) {
            System.out.println("popup not found");
        }
    }
}

