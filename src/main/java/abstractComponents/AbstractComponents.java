package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class AbstractComponents {

    WebDriver driver;
    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
    }

    By toast = By.cssSelector(".Toastify__toast-body div:nth-child(2)");

    public String getToastMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toast));
        return toastMessage.getText();
    }

     public void waitForToastToDisappear(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toast));
    }

    public void waitForFileToDownload(String path) throws RuntimeException {
        File file = new File(path);
        int timeout = 10;
        while(true){
            if(file.exists()){
                return;
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            timeout --;

        }
    }

}



