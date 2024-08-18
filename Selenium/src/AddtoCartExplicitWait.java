import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AddtoCartExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
//      Add item to Cart by using GREENCART Website Start
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        String [] vegetables = {"Tomato", "Cauliflower", "Brinjal", "Beetroot"};
        //Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.product-name")));
        List<WebElement> vegList = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < vegList.size(); i++)
        {
            List expectedVegetables = Arrays.asList(vegetables);
            int j=0;
            String [] itemsList = vegList.get(i).getText().split("-");
            String itemName = itemsList[0].trim();

            if(expectedVegetables.contains(itemName))
            {
                j++;
                driver.findElements(By.cssSelector(".product-action button")).get(i).click();
                if(j==expectedVegetables.size())
                    break;
            }

        }
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.cssSelector(".cart-preview.active button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
        driver.findElement(By.className("promoCode")).sendKeys("rahulsheetacademy");
        driver.findElement(By.className("promoBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
        System.out.println(driver.findElement(By.className("promoInfo")).getText());
        
        //      Add item to Cart by using GREENCART Website END


        //      Add item to Cart by using DARAZ Website Start
        driver.get("https://www.daraz.pk/");
        String searchedItem = "sequence";

        driver.findElement(By.cssSelector("input[placeholder='Search in Daraz']")).click();
        driver.findElement(By.cssSelector("input[placeholder='Search in Daraz']")).sendKeys(searchedItem);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.suggest-common--2KmE")));
        List<WebElement> suggestedList = driver.findElements(By.cssSelector("a.suggest-common--2KmE"));
        for(int j=0; j<suggestedList.size(); j++)
        {
            if(suggestedList.get(j).getText().equalsIgnoreCase("Sequence game"))
            {
                suggestedList.get(j).click();
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.title-wrapper--IaQ0m")));
        List<WebElement> searchedItemsList = driver.findElements(By.cssSelector("div.title-wrapper--IaQ0m"));
        for(int j=0; j<searchedItemsList.size(); j++)
        {
            String[] splitedName = searchedItemsList.get(j).getText().split(" ");
            String firstWord = splitedName[0].trim();

            if(firstWord.equalsIgnoreCase("Urban"))
            {
                searchedItemsList.get(j).click();
                break;
            }
        }

        //      Add item to Cart by using DARAZ Website
	}

}
