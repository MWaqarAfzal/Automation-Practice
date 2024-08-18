package coreJavaPractice;

import org.testng.annotations.*;

public class Vehicle {

	
	@BeforeMethod
	public void before()
	{
		System.out.println("Execute me first");
	}
	
	@AfterMethod
	public void after()
	{
		System.out.println("Execute me at the end");
	}
	
	
	public void tyres()
	{
		System.out.println("A Vehicle must has atlease 4 tyres");
	}

}
