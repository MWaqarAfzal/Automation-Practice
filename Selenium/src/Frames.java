import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		
        driver.get("https://jqueryui.com/droppable/");
        //      Switch to the Frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        //      Use the Actions class to drag and drop the Webelement from source to the target location
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();

        //      Switch back to the Default Content
        driver.switchTo().defaultContent();

         

        //      FRAME Assignment
        //driver.get("https://the-internet.herokuapp.com/");
        //driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();

       // driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
       // driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
       // System.out.println(driver.findElement(By.id("content")).getText());

	}

}
