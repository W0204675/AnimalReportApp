
public class Walrus extends Animal {

private String dentalHealth;
	
	public Walrus(String sex, int weight, String dentalHealth)
	{
		super(sex, weight);
		this.dentalHealth = dentalHealth;
	}

	public String getDentalHealth()
	{
		return dentalHealth;
	}
	
	public void setDentalHealth(String dentalHealth)
	{
		this.dentalHealth = dentalHealth;
	}
}
