package testNGPractice;

import org.testng.annotations.Test;

public class HomeLoan {
	
	@Test
    public void WebLoginHomeLoan() {
        System.out.println("Home Loan --> Hello this is web login home loan test case");
    }
	@Test
    public void MobileLoginHomeLoan()
    {
        System.out.println("Home Loan --> Hello this is mobile login home loan test case");
    }
    @Test
    public void ApiLoginHomeLoan()
    {
        System.out.println("Home Loan --> Hello this is api login home loan test case");
    }
}
