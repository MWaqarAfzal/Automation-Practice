import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddtoCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /*
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        String [] vegetables = {"Tomato", "Cauliflower", "Brinjal", "Beetroot"};
        //Thread.sleep(3000);
        addToCartGreenCart(driver, vegetables);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.cssSelector(".cart-preview.active button")).click();
        driver.findElement(By.className("promoCode")).sendKeys("rahulsheetacademy");
        driver.findElement(By.className("promoBtn")).click();
        System.out.println(driver.findElement(By.className("promoInfo")).getText());

         */


        //      ADD Items to the Cart in DARAZ Application START

        driver.get("https://www.daraz.pk/");
        String searchedItem = "sequence";
        addToCartDaraz(driver, searchedItem);



    }
    public static void addToCartGreenCart(WebDriver driver, String[] vegetables) throws InterruptedException {
        //      Get the list of all the Vegetables elements locators name and store into a list
        List<WebElement> vegList = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < vegList.size(); i++)
        {
            //      Convert the Vegetable array list into List to compare the actual and expected name
            List expectedVegetables = Arrays.asList(vegetables);
            int j=0;
            //      Get the text of element at i index and the split it based on "-" and store it in Array because after split two separate
            //      names are displayed
            String [] itemsList = vegList.get(i).getText().split("-");
            //      Trim the spaces of 1st index value of array after split and store it into a String
            String itemName = itemsList[0].trim();

            if(expectedVegetables.contains(itemName))
            {
                j++;
                //      Click on the i-th index Add to Cart button
                driver.findElements(By.cssSelector(".product-action button")).get(i).click();

                //      Add the if condition to check that if the j value equal to the Expected Vegetables list size and break the loop
                if(j==expectedVegetables.size())
                    break;
            }

        }
    }
    public static void addToCartDaraz(WebDriver driver, String searchedItem)
    {
        driver.findElement(By.cssSelector("input[placeholder='Search in Daraz']")).click();
        driver.findElement(By.cssSelector("input[placeholder='Search in Daraz']")).sendKeys(searchedItem);
        List<WebElement> suggestedList = driver.findElements(By.cssSelector("a.suggest-common--2KmE"));
        for(int j=0; j<suggestedList.size(); j++)
        {
            if(suggestedList.get(j).getText().equalsIgnoreCase("Sequence game"))
            {
                suggestedList.get(j).click();
                break;
            }
        }
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
    }

	}


