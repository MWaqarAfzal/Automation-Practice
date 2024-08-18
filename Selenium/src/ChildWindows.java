import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class ChildWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.className("blinkingText")).click();

        //      Get Windows and Iterate it to reach the desired window
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        Thread.sleep(2000);
        driver.switchTo().window(childWindow);
        Thread.sleep(2000);
        //      Get the text and split --> Trim --> Split --> Get the 0th index value
        String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys(emailID);

	}

}
