package Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class selectSelnium {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver=null;
        try{
            driver= new ChromeDriver();
            driver.get("https://letcode.in/dropdowns");
            WebElement selection = driver.findElement(By.id("fruits"));

            Select slct = new Select(selection);

           //To get the options
            List<WebElement> slist= slct.getOptions();
           for(WebElement opts:slist){
               System.out.println(opts.getText());
           }

           //Select a option using index
            slct.selectByIndex(1);

           //Select a option using
            slct.selectByVisibleText("Banana");

            //Select using value
            slct.selectByValue("2");

            //select the last option

            slct.selectByIndex(slist.size()-1);
        }
        catch (WebDriverException e){
            System.out.println("Exception: "+e.getMessage());
        }
        finally
        {
            if(driver!=null)
            {
                driver.close();
            }
        }
    }
}
