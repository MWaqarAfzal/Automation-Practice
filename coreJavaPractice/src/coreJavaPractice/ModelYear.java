package coreJavaPractice;

public class ModelYear extends SuperModel{
	
	int modelYear;
	
	//	Parameterize Constructor
	public ModelYear(int modelYear) 
	{
		super(modelYear);
		this.modelYear=modelYear;
	}

	public int modelIncrement()
	{
		modelYear = modelYear + 1;
		return modelYear;
	}
	
	public int modelDecrement()
	{
		modelYear = modelYear - 1;
		return modelYear;
	}

}
