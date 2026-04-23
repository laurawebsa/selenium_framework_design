package pageObjects;

import abstractComponents.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  extends BasePage{

      WebDriver driver;
      public LoginPage(WebDriver driver){
          super(driver);
          this.driver =driver;
          PageFactory.initElements(driver,this);
      }

      @FindBy(css = "#user-name")
      WebElement userName;

      @FindBy(css = "#password")
      WebElement userPassword;

      @FindBy(css = "#login-button")
      WebElement loginButton;

      public void goTo(String url){

          driver.get(url);
      }

      public ProductCatalog userLogin(String username, String password) {
          userName.sendKeys(username);
          userPassword.sendKeys(password);
          loginButton.click();
          return new ProductCatalog(driver);
      }
}
