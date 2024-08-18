import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
public class GetHeightWidth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement name = driver.findElement(By.cssSelector(".form-control[name='name']"));
        int height = name.getRect().getDimension().getHeight();
        int width = name.getRect().getDimension().getWidth();

        System.out.println("Height of name field is " + height);
        System.out.println("Width of name field is " + width);

	}

}
