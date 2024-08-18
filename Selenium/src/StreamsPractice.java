import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class StreamsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("th[role='columnheader']:nth-child(1)")).click();

        //      Get the list of WebElements and store into a List
        List<WebElement> vegetablesList = driver.findElements(By.xpath("//tr/td[1]"));
        //      Get the text of all WebElement by using stream map function and store into a list after converting into a list
        List<String> originalList = vegetablesList.stream().map(s->s.getText()).collect(Collectors.toList());
        //      Apply the sorting on the original list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        //      Compare the original list which is sorted after clicking on the sort icon and
        //      sorted list which is sorted after apply JAVA Stream by using Assert
        //Assert.assertEquals(sortedList, originalList);
        Assert.assertTrue(sortedList.equals(originalList));

        List<String> vegetablePrice = vegetablesList.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s)).collect(Collectors.toList());
        vegetablePrice.stream().forEach(System.out::println);

    }

    private static String getPrice(WebElement s) {
        String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }

	}

