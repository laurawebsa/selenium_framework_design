package testExecution;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.PageGrid;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;


public class GridTest {

     WebDriver driver;
     PageGrid page;
     String filePath = System.getProperty("user.home") + "/Downloads/download.xlsx";

     @BeforeMethod(alwaysRun = true)
     public void setUp(){
         driver = new ChromeDriver();
         page = new PageGrid(driver);
         page.goTo();
     }

     @Test
     public void endToEndTest() {

         //GET PRICE
         String price = page.getPriceFruit("Apple");
         Assert.assertNotNull(price);
         System.out.println("Apple prices is: " + price);

         //UPLOAD
         page.uploadFile(filePath);

         String message = page.getToastMessage();
         Assert.assertTrue(message.toLowerCase().contains("successfully"));
         page.waitForToastToDisappear();
     }
     @Test(groups = {"changePrice"})
     public void changePriceFile() throws IOException {

         downloadFile();
         File file = new File(filePath);
         //All the data from the file we upload is saved
         FileInputStream inputStream = new FileInputStream(file);
         XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
         XSSFSheet sheet = workbook.getSheetAt(0);
         int rowCount = sheet.getLastRowNum();
         for (int i = 1; i <= rowCount; i++) {
             XSSFRow row = sheet.getRow(i);
             if (row.getCell(1).getStringCellValue().equals("Apple")) {
                 double price = row.getCell(3).getNumericCellValue();
                 double newPrice = price + 10;
                 row.getCell(3).setCellValue(newPrice);
                 break;
             }
         }
         inputStream.close();
         FileOutputStream outputStream = new FileOutputStream(filePath);
         workbook.write(outputStream);
         outputStream.close();
         workbook.close();

         page.uploadFile(filePath);

         String message = page.getToastMessage();
         page.waitForToastToDisappear();
     }

     public void downloadFile() throws IOException {

         page.downloadFile();
         page.waitForFileToDownload(filePath);
     }

     @AfterMethod(alwaysRun = true)
     public void tearDown(){
         driver.quit();
     }

}
