import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert softAssert = new SoftAssert();
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            String linkText = link.getText();
            //      Create a URL class variable and call the openConnection() method
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            //      Call the setRequestMethod and pass the HEAD
            connection.setRequestMethod("HEAD");
            //      Make the connection by using the connect() method
            connection.connect();
            //      Get the response of the request and store in a variable
            int responseCode = connection.getResponseCode();
            softAssert.assertTrue(responseCode<400, "The link with Text " + linkText + "is broken with status code " + responseCode);
            
            if(responseCode > 400)
            {
                String brokenLinksText = link.getText();
                System.out.println("The link with Text " + brokenLinksText + " is broken " + "with status code " + responseCode);
                softAssert.assertTrue(false);
            }

        }
        softAssert.assertAll();

	}

}
