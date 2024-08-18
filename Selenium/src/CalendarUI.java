import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class CalendarUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        //String month = "July";
        //String day = "15";
        //String year = "2027";

        String monthNumber = "6";
        String date = "15";
        String year = "2027";
        //      Declare the array to store all the variable into one single place and then compare it in the Assertion
        String[] expectedList = {monthNumber,date,year};

        /*

        ===========     My Approach     ===========

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.className("react-date-picker__inputGroup")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        Thread.sleep(1000);

        //      Get the list of Years and select it
        List<WebElement> calendarYear = driver.findElements(By.cssSelector("button.react-calendar__tile"));
        for(int i=0; i<calendarYear.size(); i++){
            if(calendarYear.get(i).getText().equals(year)){
                calendarYear.get(i).click();
                break;
            }
        }
        List<WebElement> calendarMonth = driver.findElements(By.cssSelector("button.react-calendar__tile"));
        for(int i=0; i<calendarMonth.size(); i++){
            if(calendarMonth.get(i).getText().equals(month)){
                calendarMonth.get(i).click();
                break;
            }
        }
        List<WebElement> calendarDay = driver.findElements(By.cssSelector("button.react-calendar__tile"));
        for(int i=0; i<calendarDay.size(); i++){
            if(calendarDay.get(i).getText().equals(day)){
                calendarDay.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);
        String selectedDate = driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@type='date']")).getAttribute("value");
        System.out.println(selectedDate);

         */

        //      Select the exact DOM by just passing the variable into the Selector
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();

        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for(int i =0; i<actualList.size();i++)
        {
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }

	}

}
