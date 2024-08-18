package testNGPractice;

import org.testng.annotations.Test;

public class CarLoan {
	
    @Test(groups = {"Smoke"})
    public void WebLoginCarLoan() {
        System.out.println("Car Loan --> Hello this is web login car loan test case");
    }
    @Test
    public void MobileLoginCarLoan()
    {
        System.out.println("Car Loan --> Hello this is mobile login car loan test case");
    }
    @Test
    public void ApiLoginCarLoan()
    {
        System.out.println("Car Loan --> Hello this is api login car loan test case");
    }
    @Test(groups = {"Smoke"})
    public void MobileSignUpCarlLoan()
    {
        System.out.println("Car Loan --> Hello this is car signup personal loan test case");
    }
    @Test
    public void MobileSignoutCarLoan()
    {
        System.out.println("Car Loan --> Hello this is mobile sign out car loan test case");
    }
    @Test
    public void MobileRegisterCarLoan()
    {
        System.out.println("Car Loan --> Hello this is mobile register car loan test case");
    }

}
