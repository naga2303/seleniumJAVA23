package form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class formsSel {
    RemoteWebDriver driver;
    @Parameters({"firstname","lasttname","browserName"})
    @Test()
    public void forms (String fName, String lName,String browserName){
      //  System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

        try{
            switch (browserName) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.err.println("browser is not defined");
                    break;
            }
            driver.get("https://letcode.in/forms");
            driver.findElement(By.id("firstname")).sendKeys(fName);
            driver.findElement(By.id("lasttname")).sendKeys(lName);
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys("naga@gmail.com");
            WebElement dpdwn = driver.findElement(By.xpath("(//div[@class=\"select\"]/select)[1]"));
            Select st = new Select(dpdwn);
            st.selectByVisibleText("Angola (+244)");
            driver.findElement(By.id("Phno")).sendKeys("9789922341");
            driver.findElement(By.id("Addl1")).sendKeys("Chennai");
            driver.findElement(By.id("Addl2")).sendKeys("TamilNadu");
            driver.findElement(By.id("state")).sendKeys("Tam");
            driver.findElement(By.id("postalcode")).sendKeys("600001");
            WebElement dp2 =driver.findElement(By.xpath("(//div[@class=\"select\"]/select)[2]"));
            Select stt = new Select(dp2);
            stt.selectByVisibleText("Algeria");
            driver.findElement(By.xpath("//input[@id=\"male\"]")).click();
            driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
        }
        catch(WebDriverException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(driver!=null){
                driver.quit();
            }
        }
    }
}
