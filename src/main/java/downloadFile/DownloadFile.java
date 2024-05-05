package downloadFile;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class DownloadFile
{
    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();
        driver.get("https://get.jenkins.io/windows-stable/2.426.1/jenkins.msi");
        Dimension ds = new Dimension(1280,720);
        driver.manage().window().setSize(ds);
        //download a file using fluent wait
        String downloadPath = "/home/nagarajan/Downloads";
        String fileName = "jenkins.msi";
        File file = new File(downloadPath,fileName);
        FluentWait<File> wait= new FluentWait<File>(file)
                .withTimeout(Duration.ofMinutes(5))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class)
                .withMessage("File is not downloaded");
        boolean bool = wait.until(f -> f.exists() && f.canRead());
        if(bool){
            System.out.println("Successfully downloaded");

        }
        else
        {
            System.out.println("Not downloaded");
        }
    }
}
