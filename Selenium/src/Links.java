import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Links {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int linksCount = driver.findElements(By.tagName("a")).size();
        System.out.println(linksCount);

        //      Limit the scope of Driver and get the count of footer links
        WebElement footerSection = driver.findElement(By.id("gf-BIG"));
        int footerSectionLinksCount = footerSection.findElements(By.tagName("a")).size();
        System.out.println(footerSectionLinksCount);

        //      Get the count of only the first section of footer
        WebElement footerColum = footerSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int footerColumnLinksCount = footerColum.findElements(By.tagName("a")).size();
        System.out.println(footerColumnLinksCount);

        //      Click on the link display in the first section of footer
        List<WebElement> links = footerColum.findElements(By.tagName("a"));
        for (int i=1; i<links.size(); i++)
        {
            String newTabClick = Keys.chord(Keys.CONTROL, Keys.ENTER);
            links.get(i).sendKeys(newTabClick);
        }
        Thread.sleep(5000);

        //      Get the Title of each new opened window
        Set<String> newWindows = driver.getWindowHandles();
        Iterator<String> iterator = newWindows.iterator();

        while (iterator.hasNext())
        {
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }

        //      Iterate each newly opened window and get the title of each window can also get by using for loop
        /*
        for(int i=0; i<links.size(); i++)
        {
            Thread.sleep(2000);
            driver.switchTo().window(iterator.next());
            String titleOfWindow = driver.getTitle();
            System.out.println(titleOfWindow);
        }
         */

	}

}
