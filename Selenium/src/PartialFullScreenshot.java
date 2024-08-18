import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PartialFullScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> windowns = driver.getWindowHandles();
        Iterator<String> ite = windowns.iterator();
        String parentWindow = ite.next();
        String childWindow = ite.next();

        File parentWindowScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(parentWindowScreenshot, new File("parentWindow.png"));

        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        Thread.sleep(3000);
        File childWindowScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(childWindowScreenshot, new File("childWindow.png"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(2000);
        List<WebElement> coursesList = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
        File courseScreenshot = coursesList.get(1).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(courseScreenshot, new File("courseScreenshot.png"));
        String courseName = coursesList.get(1).getText();

        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);
        WebElement nameFiled = driver.findElement(By.cssSelector(".form-control[name='name']"));
        nameFiled.sendKeys(courseName);
        File nameFieldScreenshot = nameFiled.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nameFieldScreenshot, new File("nameFieldScreenshot.png"));

	}

}
