package testNGDemo;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeLoan {

	@Parameters({"URL", "APIKey"})
    @Test (groups = {"Smoke"})
    public void WebLoginHomeLoan(String url, String key) {
		System.out.println(url);
        System.out.println("Home Loan --> Hello this is web login home loan test case");
        System.out.println(key);
        
        Assert.assertTrue(false);
    }
    
    public void MobileLoginHomeLoan()
    {
        System.out.println("Home Loan --> Hello this is mobile login home loan test case");
    }
    
    public void ApiLoginHomeLoan()
    {
        System.out.println("Home Loan --> Hello this is api login home loan test case");
    }
}
