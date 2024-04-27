package fileUploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileUploadDownloadSel {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver= null;
        try{
            driver = new ChromeDriver();
            driver.get("https://letcode.in/file");
          WebElement fileUpload = driver.findElement(By.xpath("//input[@type=\"file\"]"));
            driver.findElement(By.xpath("//input[@type=\"file\"]")).click();
            String filePath = "D:/DOC/Txxx.txt";
            fileUpload.sendKeys("D:/DOC/Txxx.txt");
        }
        catch (WebDriverException e){
            System.out.println(e.getMessage());
        }
       /*finally {
            if(driver!=null){
                driver.quit();
            }
        } */

    }
}
