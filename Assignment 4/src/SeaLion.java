
public class SeaLion extends Animal {
	
private int numOfSpots;
	
	public SeaLion(String sex, int weight, int numOfSpots)
	{
		super(sex, weight);
		this.numOfSpots = numOfSpots;
	}

	public double getNumOfSpots()
	{
		return numOfSpots;
	}
	
	public void setNumOfSpots(int numOfSpots)
	{
		this.numOfSpots = numOfSpots;
	}
}
