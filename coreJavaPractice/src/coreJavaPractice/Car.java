package coreJavaPractice;

import org.testng.annotations.Test;

public class Car extends Vehicle {

	@Test
	public void runTest()
	{
		int model = 1995;
		ModelYear my = new ModelYear(model);
		System.out.println(my.modelDecrement());
		System.out.println(my.modelIncrement());
		tyres();
		System.out.println(my.multipleTwo());
		
	}

}
