import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Action {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);
        //Thread.sleep(5000);
        WebElement element = driver.findElement(By.cssSelector("#nav-link-accountList"));
        System.out.println(element.isDisplayed());
        a.moveToElement(element).build().perform();

        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        //  KeyDown(Keys.KeyName) is used to hold and press the specific key
        //  doubleClick() is used to double click on the element.
        Thread.sleep(2000);
        a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        a.moveToElement(element).contextClick().build().perform();

	}

}
