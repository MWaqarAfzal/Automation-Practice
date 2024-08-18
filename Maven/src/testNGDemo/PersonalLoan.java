package testNGDemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PersonalLoan {

	@Parameters({"PersonalLoanURL", "PersonalLoanKey"})
    @Test(groups = {"Smoke"})
    public void WebLoginPersonalLoan(String ploanURL, String pLoanKey) {
        System.out.println("Personal Loan --> Hello this is web login personal loan test case");
        System.out.println(ploanURL);
        System.out.println(pLoanKey);
    }
    @Test (timeOut = 4000) // It will wait for the 4 second to fail the test case
    public void MobileLoginPersonalLoan()
    {
        System.out.println("Personal Loan --> Hello this is mobile login personal loan test case");
    }
    @Test(dataProvider="getData")
    public void ApiLoginPersonalLoan(String username, String password)
    {
        System.out.println("Personal Loan --> Hello this is api login personal loan test case");
        System.out.println(username);
        System.out.println(password);
    }
    
    @DataProvider
    public Object[][] getData()
    {
    	Object [][] data = new Object[3][2];
    	// [3] defined the number of rows and [2] defined the number of columns
    	
    	//	1st data set
    	data[0][0] = "firstname";
    	data[0][1] = "firstPassword";
    	
    	//	2nd data set
    	data[1][0] = "secondname";
    	data[1][1] = "secondPassword";
    	
    	//	3rd data set
    	data[2][0] = "thirdname";
    	data[2][1] = "thirdPassword";
    	
    	return data;
    }
	
}
