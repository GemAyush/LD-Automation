package scenario1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class loginPage {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "C:/Users/ayush.saxena/Downloads/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://geminisolutions.talentlms.com/");

        //username
        WebElement username = driver.findElement(By.name("login"));
        username.sendKeys("ayush.saxena@geminisolutions.com");

        //password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Ayush123@");

        //click on login button
        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.findElement(By.xpath("//div[@class = 'toast-message']"));
            WebElement forgetPassword = driver.findElement(By.partialLinkText("password"));
            forgetPassword.click();
            driver.findElement(By.name("username")).sendKeys("ayush.saxena@geminisolutions.com");

            WebElement sendBtn = driver.findElement(By.name("submit_login"));
            sendBtn.click();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.equals("https://geminisolutions.talentlms.com/")){
            System.out.println("Authentication Unsuccessful");
        }
        else {
            System.out.println("Authentication Successful!");
        }
        driver.quit();
    }
}
