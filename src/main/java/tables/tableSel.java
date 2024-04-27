package tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class tableSel {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("https://letcode.in/table");
            WebElement table = driver.findElement(By.id("shopping"));

            //Case 1 - Print header
            WebElement tablesHeader = table.findElement(By.tagName("thead"));
            WebElement headerRows = tablesHeader.findElement(By.tagName("tr"));
            List <WebElement> ths = headerRows.findElements(By.tagName("th"));
            for(WebElement th:ths){
               // WebElement header =th.findElement(By.tagName("th"));
                System.out.println(th.getText());
            }

            //Case 2 - Price total
            List <WebElement>bodyRows = table.findElements(By.xpath("//table[@id=\"shopping\"]/tbody/tr"));
            int [] ar = new int[bodyRows.size()];
            for(int i=0;i<bodyRows.size();i++){
                String td = bodyRows.get(i).findElement(By.xpath("td[2]")).getText();
                ar[i]=Integer.parseInt(td);
            }
            int sum = Arrays.stream(ar).reduce(0,(a,b)->a + b);
            System.out.println(sum);


            //Case 2 Make raj as present
            WebElement table2Rows = driver.findElement(By.xpath("//table[@id=\"simpletable\"]/tbody"));
            List <WebElement> rows = table2Rows.findElements(By.tagName("tr"));
            System.out.println("Second Table rows: "+rows.size());
            for(int i=0;i<rows.size();i++){
                String lastName = rows.get(i).findElement(By.xpath("td[2]")).getText();
                if(lastName.equalsIgnoreCase("Raj")){
                    rows.get(i).findElement(By.xpath("td[4]/input")).click();
                }
            }
            Boolean isChecked = driver.findElement(By.xpath("(//table[@id=\"simpletable\"]/tbody/tr/td[4]/input)[2]")).isSelected();
            System.out.println("Checked: "+isChecked);

            //Case 3 - advance table
            driver.get("https://letcode.in/advancedtable");

            WebElement ele = driver.findElement(By.xpath("//select[@name = \"advancedtable_length\"]"));
            Select st = new Select(ele);
            st.selectByValue("25");
            driver.findElement(By.xpath("//input[@type = \"search\"]")).sendKeys("ab");
            WebElement tb = driver.findElement(By.id("advancedtable"));
            List <WebElement> rowsAdvanced = tb.findElements(By.xpath("//tbody/tr"));
            System.out.println("Advanced rows: "+rowsAdvanced.size());
            for(int i=0;i<rowsAdvanced.size();i++) {
                List<WebElement> cells = rowsAdvanced.get(i).findElements(By.tagName("td"));
                for (int j = 0; j < cells.size(); j++) {
                    String cellValue = cells.get(j).getText();
                    System.out.println("Cell Value: " + cellValue + "\t");
                }
            }
        }
        catch(WebDriverException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(driver!=null){
                driver.quit();
            }
        }
    }
}
