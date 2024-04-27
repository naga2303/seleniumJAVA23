package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class framesSel
{
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver= null;
        try{
            driver = new ChromeDriver();
            driver.get("https://letcode.in/frame");
            WebDriver frames= driver.switchTo().frame("firstFr");
            frames.findElement(By.xpath("//input[@name=\"fname\"]")).sendKeys("Naga");
            WebElement childF = driver.findElement(By.xpath("//iframe[@src=\"innerFrame\"]"));
            WebDriver childFrame = driver.switchTo().frame(childF);
            childFrame.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("InsideFrame");
            childFrame.switchTo().parentFrame();
            frames.findElement(By.xpath("//input[@name=\"lname\"]")).sendKeys("Rajan");
            frames.switchTo().defaultContent();
            List<WebElement> frameCount = driver.findElements(By.tagName("iframe"));
            System.out.println(frameCount.size());
        }
        catch(WebDriverException e){
            System.out.println(e.getMessage());

        }
        finally {
            if(driver!=null){
                driver.close();
            }
        }
    }
}
