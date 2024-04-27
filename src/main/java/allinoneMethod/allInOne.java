package allinoneMethod;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

import java.net.SocketException;
import java.util.concurrent.TimeUnit;

public class allInOne
{
    @Test(groups = {"regression","smoke"})
    public  void  alertTest (){
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
    @Test(groups = {"regression"})
    public void button(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("https://letcode.in/buttons");

            //Case 1
            driver.findElement(By.id("home")).click();
            String urlNew = driver.getCurrentUrl();
            System.out.println("New URL"+urlNew);
            driver.navigate().back();
            String currentURL = driver.getCurrentUrl();
            if(currentURL.equalsIgnoreCase("https://letcode.in/buttons")){
                System.out.println("Safely back to the url");
            }
            else
            {
                driver.navigate().to("https://letcode.in/buttons");
            }

            //Case 2
            Rectangle rectValues =driver.findElement(By.id("position")).getRect();
            System.out.println("X Axis: "+rectValues.getX());
            System.out.println("Y Axis: "+rectValues.getY());

            //Case 3 - finding the color
            String colorButton = driver.findElement(By.id("color")).getCssValue("background-color");
            System.out.println(colorButton);

            //Case 4 - Find the height and weight
            Dimension size = driver.findElement(By.id("property")).getSize();
            System.out.println(size.getHeight()+":"+ size.getWidth());

            //Confirm if the button disabled
            Boolean enabled = driver.findElement(By.xpath("(//button[@id =\"isDisabled\"])[1]")).isEnabled();
            System.out.println(enabled);

            //Click and Hold Button
            driver.findElement(By.xpath("(//button[@id =\"isDisabled\"])[2]")).click();

            Actions action = new Actions(driver);
            action.clickAndHold();

        }
        catch (WebDriverException e){
            System.out.println("Web driver exception"+e.getMessage());
        }
        finally{
            if (driver!=null){
                driver.close();
            }
        }
    }
    @Test(groups = { "smoke" })
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
