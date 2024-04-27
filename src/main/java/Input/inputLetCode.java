package Input;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataUtils;

public class inputLetCode
{
    //multiple data providers can be set - data provider must be string of 2 dimensional array
    //Data Utils either can be inherited or use the attribute dataprovider.class
    //@Parameters and dataprovider should not be used in a single test method,
    //if used, the dataProvider will have the higher precedence.
    //In the input, instead of passing each arugment, an array can be passed and
    //the index value can be called.
    //void input(String data[]) --> driver.findElement(By.id("fullName")).sendKeys(data[0]);
@Test(dataProvider = "getData", dataProviderClass = DataUtils.class)
    public  void input(String data[]){


        System.setProperty("webdriver.chorme.driver","./drivers/chromedriver.exe");
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://letcode.in/edit");

            //Case 1 - To type in the text box.
            driver.findElement(By.id("fullName")).sendKeys(data[0]);
            String txt = driver.findElement((By.xpath("(//label[@class=\"label\"])[1]"))).getText();
            System.out.println(txt);
           // assert (txt).equals("Enter you Names");

            //case 2 - To press tab key and retrieve the text
            driver.findElement(By.id("join")).sendKeys(data[1], Keys.TAB);
            WebElement eleFocused = driver.findElement(By.id("getMe"));
            WebElement expFocused = driver.switchTo().activeElement();
            if(expFocused.equals(eleFocused)){
                System.out.println("Key pressed");
            }
            else{
                System.out.println("Key not pressed");
            }
            //Get the text inside the text box
            String getMeText = driver.findElement(By.id("getMe")).getText();
            System.out.println(getMeText);

            //Clear the text
            driver.findElement(By.id("clearMe")).clear();
            String clearText = driver.findElement(By.id("clearMe")).getText();
            if(clearText.isEmpty()){
                System.out.println("It is empty");
            }
            else{
                System.out.println("Yet to clear the text");
            }

            //Confirm text box is disabled
            Boolean bool = driver.findElement(By.id("noEdit")).isEnabled();
            System.out.println(bool);

            //Confirm text box is readonly
            String atr = driver.findElement(By.id("dontwrite")).getAttribute("readonly");
            System.out.println("Attribute: "+atr);
            if(atr.equalsIgnoreCase("true")){
                System.out.println("this textbox is readonly");
            }
            else
            {
                System.out.println("Text box is not readonly");
            }
        }



        catch (WebDriverException e){
            System.out.println("WebDriver Exception occurred"+e.getMessage());
        }
        finally {
            if(driver!=null){
                driver.quit();
            }
        }


    }
}
