package slider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class sliderSel {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver= null;
        try{
            driver = new ChromeDriver();
            driver.get("https://letcode.in/slider");
            WebElement slider = driver.findElement(By.id("generate"));
            Actions act = new Actions(driver);
            act.dragAndDropBy(slider,24,0).build().perform();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        catch (WebDriverException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(driver!=null){
                driver.close();
            }
        }
    }
}
