import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticeCodes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
	    /*
	    driver.get("http://sandbox.tenant-platform.com/login");
	    driver.findElement(By.cssSelector("input[name='username']")).sendKeys("hummingbird");
	    driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Tenant2020");
	    driver.findElement(By.cssSelector("button[name*='QA-Login']")).click();
	    Thread.sleep(15000);
	    String CurrentURL = driver.getCurrentUrl();
	    System.out.println(CurrentURL);
	    Thread.sleep(10000);
	    String dashboardTitle = driver.findElement(By.cssSelector("div.hb-header-font-size")).getText();
	    System.out.println(dashboardTitle);
	    driver.findElement(By.cssSelector("button[name*='flash-circle']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("+ Create New Contact")).click();
	    Thread.sleep(5000);

	    driver.findElement(By.id("input-2102")).click();
	    */


	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	    //      ====================================================

	    //      ====================================================
	    //      STATIC DROPDOWN SELECTION START

	    WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	    Select select = new Select(dropdown);
	    select.selectByIndex(2);
	    String selectedValue = select.getFirstSelectedOption().getText();
	    System.out.println(selectedValue);
	    select.selectByVisibleText("USD");
	    String selectedValue2 = select.getFirstSelectedOption().getText();
	    System.out.println(selectedValue2);
	    select.selectByValue("INR");
	    String selectedValue3 = select.getFirstSelectedOption().getText();
	    System.out.println(selectedValue3);

	    //      STATIC DROPDOWN SELECTION END
	    //      ====================================================

	    //      ====================================================
	    Thread.sleep(2000);
	    driver.findElement(By.id("divpaxinfo")).click();
	    Thread.sleep(1500L);
	    for(int i=1;i<5;i++)
	    {
	        driver.findElement(By.id("hrefIncAdt")).click();
	        Thread.sleep(1000L);
	    }
	    driver.findElement(By.id("btnclosepaxoption")).click();
	    Thread.sleep(500L);
	    //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	    Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
	    //      ====================================================

	    //      ====================================================
	    //      DYNAMIC DROPDOWN SELECTION START

	    //      FIRST SELECT THE PARENT TAG AREA AND THEN SEARCH THE ELEMENT INTO THAT SELECTED PARENT ELEMENTS LIST
	    driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']  [@value='Departure City']")).click();
	    //      IF THERE ARE MULTIPLE LOCATORS WITH THE SAME XPATH THEN USE THE INDEXES TO CLICK ON THE REQUIRED LOCATOR
	    //driver.findElement(By.xpath("(//input[@value='Departure City'])[1]")).click();
	    driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
	    //driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

	    //      DYNAMIC DROPDOWN SELECTION END
	    //      ====================================================

	    //      ====================================================
	    //      VALIDATING IF THE UI ELEMENTS ARE ENABLED OR DISABLED WITH ATTRIBUTES START

	    driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	    if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
	    {
	        System.out.println("The Retuen Date Calendar is Enabled");
	        Assert.assertTrue(true);
	    }
	    else {
	        System.out.println("The Return date Calendar is disabled");
	        Assert.assertFalse(false);
	    }

	    //      VALIDATING IF THE UI ELEMENTS ARE ENABLED OR DISABLED WITH ATTRIBUTES END
	    //      ====================================================

	    //      AUTO-SUGGEST DROPDOWN SELECTION START

	    driver.findElement(By.id("autosuggest")).sendKeys("ind");
	    Thread.sleep(3000);
	    List<WebElement> autoSuggest = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
	    for(WebElement element:autoSuggest)
	    {
	        if(element.getText().equalsIgnoreCase("India"))
	        {
	            element.click();
	            break;
	        }
	    }

	    //      AUTO-SUGGEST DROPDOWN SELECTION END
	    //      ====================================================

	    //      ====================================================
	    //      CHECK BOX SELECTION AND GET THE COUNT OF CHECKBOX AND ADD THE ASSERTION TO CHECK THAT THE CHECKBOX IS SELECTED OR NOT

	    //System.out.println("The status of checkbox before selected is " + driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	    Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	    driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
	    //System.out.println("The status of checkbox after selected is " + driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	    Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	    int checkboxCount = driver.findElements(By.cssSelector("[type='checkbox']")).size();
	    //System.out.println("The total number of checkbox present in the website are " + checkboxCount);

	    //      CHECKBOX SELECTION IS END
	    //      ====================================================

	    //      ====================================================
	    //      JAVA SCRIPT ALERT HANDLING START

	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    driver.findElement(By.id("name")).sendKeys("Waqar");
	    Thread.sleep(1000);
	    driver.findElement(By.id("alertbtn")).click();
	    System.out.println("The Text present in the Alert box is " + driver.switchTo().alert().getText());
	    Thread.sleep(1000);
	    driver.switchTo().alert().accept();

	    Thread.sleep(1000);

	    driver.findElement(By.id("name")).sendKeys("Waqar");
	    driver.findElement(By.id("confirmbtn")).click();
	    Thread.sleep(500);
	    System.out.println("The Text present in the Alert box is " + driver.switchTo().alert().getText());
	    Thread.sleep(500);
	    driver.switchTo().alert().dismiss();
	    //      JAVA SCRIPT ALERT HANDLING END
	    //      ====================================================

	    //      ====================================================

	}

}
