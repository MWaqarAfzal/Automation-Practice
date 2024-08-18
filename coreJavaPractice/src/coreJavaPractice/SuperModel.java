package coreJavaPractice;

public class SuperModel {
	
	int modelYear;
	
	public SuperModel(int modelYear) 
	{
		this.modelYear=modelYear;
	}

	public int multipleTwo()
	{
		modelYear = modelYear * 2;
		return modelYear;
	}

}
