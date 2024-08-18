import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        //      document.querySelector('cssSelector').scrollTop=5000 is used to scroll within the table
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        
        int sum = 0;
        List<WebElement> amount = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        for (int i = 0; i < amount.size(); i++)
        {
            sum = sum + Integer.parseInt(amount.get(i).getText());
        }
        System.out.println(sum);
        String [] actualAmount = driver.findElement(By.className("totalAmount")).getText().split(":");
        int totalAmount = Integer.parseInt(actualAmount[1].trim());
        Assert.assertEquals(sum, totalAmount);

	}

}
