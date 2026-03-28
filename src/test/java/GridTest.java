import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.PageGrid;

import java.io.File;


public class GridTest {

     WebDriver driver;
     PageGrid page;

     @BeforeMethod
     public void setUp(){
         driver = new ChromeDriver();
         page = new PageGrid(driver);
         page.goTo();
     }

     @Test
     public void endToEndTest() {

         String filePath = System.getProperty("user.home") + "/Downloads/download.xlsx";

         // 1. DOWNLOAD
         page.downloadFile();
         page.waitForFileToDownload(filePath);

         // 2. GET PRICE
         String price = page.getPriceFruit("Apple");
         Assert.assertNotNull(price);
         System.out.println("Apple prices is: " + price);

         // 3. UPLOAD
         page.uploadFile(filePath);

         String message = page.getToastMessage();
         Assert.assertTrue(message.toLowerCase().contains("success"));
         page.waitForToastToDisappear();
     }

     @AfterMethod
     public void tearDown(){
         driver.quit();
     }


}
