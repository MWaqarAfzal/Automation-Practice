package rahulshetty.ExtentReportProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentDemo {
	
	//		Create the Object of Extent Report Globally to access in the Test Case
	ExtentReports reports;
	
	@BeforeTest
	public void extentReportConfig()
	{
		//		Create dynamically path where the report will save
		String reportPath = System.getProperty("user.dir") + "\\reports\\index.html";
		//		Create Object of Extent Spark Report
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		//		Set the configuration of the report
		sparkReport.config().setReportName("Web Automation Results");
		sparkReport.config().setDocumentTitle("Test Result");
		
		//		Create the Object of Main Class which is Extent Report
		reports = new ExtentReports();
		//		Attached the Extent Spark Report to the Extent Report
		reports.attachReporter(sparkReport);
		//		Set the Tester Name
		reports.setSystemInfo("Tester", "Waqar Afzal");
		

	}
	
	@Test
	public void browserSetup()
	{
		//		Create Extent Report Test
		//reports.createTest("Extent Report Demo");
		
		//		Create the Object of Extent Test and explicitly fail the test method
		ExtentTest test = reports.createTest("Extent Report Demo");
				
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://rahulshettyacademy.com/");
		String pageTitle = driver.getTitle();
		System.out.println("The page title is " + pageTitle);
		
		test.fail("Explicityly fail the test case");
		
		//		Finish the Extent Report at the end of last executed test method.
		reports.flush();
		
	}

}
