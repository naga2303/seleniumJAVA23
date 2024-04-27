package windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class windowsel {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver=null;
        try{
            driver = new ChromeDriver();
            driver.get("https://letcode.in/windows");
            driver.findElement(By.id("home")).click();
            Set<String> windows = driver.getWindowHandles();
            System.out.println("windows: "+windows.size());
            String parentWindow = driver.getWindowHandle();
            String wind1 ="";
            for(String win:windows){
                WebDriver wind = driver.switchTo().window(win);
                if(wind.getCurrentUrl().equalsIgnoreCase("https://letcode.in/test")){
                    wind1 = wind.getWindowHandle();
                }
                System.out.println("url: "+wind.getCurrentUrl());

            }
            WebDriver wind1Driver = driver.switchTo().window(wind1);
            System.out.println("Current URL:"+wind1Driver.getCurrentUrl());
            wind1Driver.findElement(By.xpath("//a[text()=\"Edit\"]")).click();

            wind1Driver.switchTo().window(parentWindow);
            System.out.println("parent window: "+driver.getCurrentUrl());
            driver.close();
        }
        catch (WebDriverException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(driver!=null){
                driver.close();
            }
        }
    }
}
