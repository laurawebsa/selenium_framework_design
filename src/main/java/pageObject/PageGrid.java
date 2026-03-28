package pageObject;

import abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class PageGrid extends AbstractComponents {

    WebDriver driver;
    public PageGrid(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#downloadButton")
    WebElement downloadButton;

    @FindBy(css = "input[type='file']")
    WebElement uploadButton;

    @FindBy(css = "div[role='rowgroup'] div[role='row']")
    List<WebElement> table;

    public void goTo() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
    }

    public String getPriceFruit(String fruit) {

        for(int i=0; i<table.size();i++){
            {
                WebElement fruitName = table.get(i).
                        findElement(By.cssSelector("div[data-column-id='2']"));
                if(fruitName.getText().equals(fruit)){
                    WebElement priceCell = table.get(i).
                            findElement(By.cssSelector("div[data-column-id='4']"));
                    return priceCell.getText();
                }
            }
        }
        return null;
    }

    public void downloadFile() {
        downloadButton.click();

    }
    public void uploadFile(String path) {
        uploadButton.sendKeys(path);
        getToastMessage();

    }

}
