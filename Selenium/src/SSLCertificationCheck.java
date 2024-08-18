import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLCertificationCheck {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

        //      Options class is used to bypass the SSL Certification issues
        ChromeOptions options = new ChromeOptions();
        //      Use the setAcceptInsecureCerts method and pass the True value to accept the SSL Certificate
        options.setAcceptInsecureCerts(true);

        WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
        //      Pass the options object to the Webdriver to let know the driver to use the options class behavior
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

        //      Take Screenshot
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\wafzal\\screenshot.png"));

	}

}
