package button;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class buttonClass {
    @Test()
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
}
