package projectobjects;

import abstract_components.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver; //local variable
    //create a constructor that will be the first method to execute
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    //Initializing all elements PageFactory
    PageFactory.initElements(driver, this);
    }

    //WebDriver userEmail = driver.findElement(By.id("userEmail"));
    //PageFactory

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(id = "userPassword")
    WebElement userPasswordField;

    @FindBy(id = "login")
    WebElement loginButton;

    public ProductCatalog loginApplication(String email, String password) {
        userEmailField.sendKeys(email);
        userPasswordField.sendKeys(password);
        loginButton.click();
        ProductCatalog productCatalog = new ProductCatalog(driver);
        return productCatalog;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/");
    }
}
