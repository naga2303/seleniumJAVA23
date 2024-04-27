package radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class radioButton {
    public static void main (String args[]){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver=null;
        try{
            driver = new ChromeDriver();
            driver.get("https://letcode.in/radio");

           //Select any one
            driver.findElement(By.xpath("//input[@id =\"yes\"]")).click();

            //Confirm last field is disabled
            String eleDisabled = driver.findElement(By.xpath("//input[@id =\"maybe\"]/parent::label")).getAttribute("disabled");
            System.out.println("Attribute: "+eleDisabled);
            if(eleDisabled.equalsIgnoreCase("true")){
                System.out.println("this radiobutton is readonly");
            }
            else
            {
                System.out.println("Text box is not readonly");
            }

            //Find if the checkbox is selected?
            Boolean isChecked = driver.findElement(By.xpath("(//input[@type =\"checkbox\"])[1]")).isSelected();
            System.out.println("Checked: "+isChecked);

            //Click Checked
            WebElement chckd= driver.findElement(By.xpath("(//input[@type =\"checkbox\"])[2]"));
            if(!chckd.isSelected()){
                chckd.click();
                System.out.println("Just now Selected");
            }
            else {
                System.out.println("Already Selected");
            }

        }
        catch (WebDriverException e){
            System.out.println("Some webdriver"+e.getMessage());
        }
        finally {
            if(driver!=null){
            driver.close();
            }
        }
    }
}
