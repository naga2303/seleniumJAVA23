package waits;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitSel
{
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("https://letcode.in/waits");
            driver.findElement(By.id("accept")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        }
        catch (WebDriverException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(driver!=null){
                driver.quit();
            }
        }

    }
}
