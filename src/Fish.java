
public class Fish {
	
	private String name;
	private String species;
	private double weight;
	
	public Fish (String fishName, String fishSpecies, double fishWeight)
	{
		name = fishName;
		species = fishSpecies;
		weight = fishWeight;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String getSpecies()
	{
		return species;
	}
	
	public double getWeight() 
	{
		return weight;
	}
	
	public String toString()
	{
		return name + ", " + species + ", " + String.format("%.1f", weight) + " lb";
	}
}
