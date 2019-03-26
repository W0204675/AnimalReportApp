
public class Penguin extends Animal {
	
	private double bloodPressure;
	
	public Penguin(String sex, int weight, double bloodPressure)
	{
		super(sex, weight);
		this.bloodPressure = bloodPressure;
	}

	public double getBloodPressure()
	{
		return bloodPressure;
	}
	
	public void setBloodPressure(double bloodPressure)
	{
		this.bloodPressure = bloodPressure;
	}
}
