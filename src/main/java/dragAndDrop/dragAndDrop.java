package dragAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;

public class dragAndDrop {
    @Test()
    public void dragDrop() throws SocketException {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("https://letcode.in/dropable");
           WebElement src = driver.findElement(By.id("draggable"));
           WebElement dest = driver.findElement(By.id("droppable"));
           Actions act = new Actions(driver);
           act.dragAndDrop(src,dest).build().perform();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
