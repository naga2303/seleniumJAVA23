package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC001AlertSel {
    @Test()
    public  void  alertTest (String[] args){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("https://letcode.in/alert");

            //Accept the alert
            driver.findElement(By.id("accept")).click();
            driver.switchTo().alert().accept();

            //Dismiss the alert and get the text
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("confirm")).click();
            String messageAlert = driver.switchTo().alert().getText();
            System.out.println(messageAlert);

            //Prompt the name and type the message
            driver.findElement(By.id("prompt")).click();
            driver.switchTo().alert().sendKeys("Successful");
            driver.switchTo().alert().accept();

        }
        catch(WebDriverException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(driver!=null){
                driver.close();
            }
        }

    }
}
