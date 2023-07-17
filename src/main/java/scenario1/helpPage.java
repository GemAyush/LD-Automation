package scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class helpPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/ayush.saxena/Downloads/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://geminisolutions.talentlms.com/");

        driver.findElement(By.name("login")).sendKeys("ayush.saxena@geminisolutions.com");
        driver.findElement(By.name("password")).sendKeys("X6v1wgQS");
        driver.findElement(By.name("submit")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.equals("https://geminisolutions.talentlms.com/")){
            System.out.println("Authentication Unsuccessful");
        }
        else {
            System.out.println("Logged In Successfully!");
        }
        System.out.println(driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //navigation
        driver.navigate().to("https://geminisolutions.talentlms.com/help");

        //test1
        driver.findElement(By.xpath("//div[normalize-space()='Video']")).click();
        currentUrl = driver.getCurrentUrl();

        List<WebElement> frames = driver.findElements(By.tagName("li"));
        if(frames.size() > 0){
            System.out.println("Working Fine!");
        }
        else{
            System.out.println("Its Failing");
        }
        driver.get("https://geminisolutions.talentlms.com/help");

        //test2
        driver.findElement(By.xpath("//div[normalize-space()='Knowledge base']")).click();
        List<String>webHandles=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(webHandles.get(1));
        currentUrl = driver.getCurrentUrl();
        driver.close();
        System.out.println("URL of Knowledge Base : " + currentUrl);
        if(currentUrl.equals("https://geminisolutions.talentlms.com/help")){
            System.out.println("Failing");
        }
        else {
            System.out.println("Working Perfectly Fine!");
            driver.switchTo().window(webHandles.get(0));
        }

        //test3
        driver.findElement(By.xpath("//div[normalize-space()='Blog']")).click();
        List<String> webHandles1 =new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(webHandles1.get(1));
        currentUrl = driver.getCurrentUrl();
        System.out.println("URL of Blog : " + currentUrl);
        if(currentUrl.equals("https://geminisolutions.talentlms.com/help")){
            System.out.println("Failing");
        }
        else {
            System.out.println("Awesome! You did it.");
            driver.switchTo().window(webHandles1.get(0));
        }
        driver.quit();
    }
}
