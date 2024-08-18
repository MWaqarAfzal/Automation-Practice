import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SortingPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("th[role='columnheader']:first-child")).click();

        List<String> vegetablePrice;
        do {
            List<WebElement> vegetableNamesList = driver.findElements(By.xpath("//tr/td[1]"));
            vegetablePrice = vegetableNamesList.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s)).collect(Collectors.toList());
            vegetablePrice.stream().forEach(System.out::println);
            if(vegetablePrice.isEmpty())
            {
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }
        }
        while (vegetablePrice.isEmpty());  //  (vegetablePrice.size()<1)

	}
    private static String getPrice(WebElement s) 
    {
        String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }

}
