package projectobjects;

import abstract_components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends AbstractComponent {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".action__submit")
    WebElement submitButton;

    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;

    /*@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
    WebElement selectCountry;*/

    By results = By.cssSelector(".ta-results");
    By selectCountry = By.xpath("(//button[contains(@class,'ta-item')])[2]");

    public void selectCountry(String countryName) {
        country.sendKeys(countryName);
        waitForElementToAppear(results);
        List<WebElement> options = driver.findElements(selectCountry);
        WebElement correctOption = options.stream()
                .filter(option -> option
                .getText().equalsIgnoreCase(countryName)).findFirst()
                .orElseThrow(()-> new RuntimeException("Country not found"));
        correctOption.click();

        /*Actions a = new Actions(driver);
        a.sendKeys(country,countryName).build().perform();
        waitForElementToAppear(results);
        selectCountry.click();*/
    }

    public ConfirmationPage submitOrder(){
        submitButton.click();
        return new ConfirmationPage(driver);
    }

}
