/**
 * Lab 2 School template
 * CS 2334 Spring 2020
 */
public class School {
	
	private Fish[] fishArray;
	private int numFish;
	private static final int DEFAULT_CAPACITY = 3;
	
	public School() {
		this(DEFAULT_CAPACITY);
	}
	
	public School(int capacity) {

		// Ensure there is space for at least one fish.
		if (capacity <= 0)
		{
			capacity = 1;
		}
		fishArray = new Fish[capacity];
		numFish = 0;
	}
	
	// Return the number of non-empty elements in fishArray.	
	public int getNumFish() 
	{
		return numFish;
	}

	// Return the length of fishArray.
	public int getCapacity()
	{
		return fishArray.length;
	}
	
	private void doubleCapacity()
	{
		Fish[] newFishArray = new Fish[fishArray.length * 2];
		for (int i = 0; i < fishArray.length; ++i)
		{
			newFishArray[i] = fishArray[i];
		}
		fishArray = newFishArray;
	}
	
	public void addFish (Fish fish)
	{
		if (numFish == fishArray.length)
		{
			doubleCapacity();
		}
		
		fishArray[numFish] = fish;
		numFish++;
	}
	
	public Fish removeFish (int index)
	{
		if (index < 0 || index >= numFish)
		{
			return null;
		}
		
		Fish fish = fishArray[index];

		Fish[] newFishArray2 = new Fish[fishArray.length];
		for(int i = 0, k = 0; i < numFish; ++i) {

			if (i == index)
			{
				continue;
			}
			newFishArray2[k++] = fishArray[i];
		}
		
		fishArray = newFishArray2;
		numFish--;
		return fish;
	}	
	
	public Fish getFish(int index) {
		
		if (index < 0 || index >= numFish) {
			return null;
		}
		
		return fishArray[index];
	}
	
	public Fish[] getFish()
	{
		Fish[] arr = new Fish[numFish];
		for(int i = 0; i < numFish; ++i)
		{
			arr[i] = fishArray[i];
		}
		return arr;
	}
	
	public Fish[] getFish(String species)
	{
		Fish[] speciesOfFishTemp = new Fish[numFish];
		int size = 0;
		
		for(int i = 0; i < numFish; ++i)
		{
			if (fishArray[i].getSpecies().equals(species))
			{
				speciesOfFishTemp[size] = fishArray[i];
				size++;
			}
		}
		
		Fish[] speciesArr = new Fish[size];
		for (int i = 0; i < size; ++i)
		{
			speciesArr[i] = speciesOfFishTemp[i];
		}
		return speciesArr;
	}
	
	public Fish getBiggestFish()
	{
		if (numFish > 0)
		{
			int index = 0;
			double biggestWeight = fishArray[index].getWeight();

			for (int i = 1; i < numFish; ++i)
			{
				if (fishArray[i].getWeight() > biggestWeight)
				{
					biggestWeight = fishArray[i].getWeight();
					index = i;
				}
			}
			return fishArray[index];
		}
		else
		{
			return null;
		}
	}
	
	public double getWeight()
	{
		double totalWeight = 0.0;
		for (int i = 0; i < numFish; ++i)
		{
			totalWeight = totalWeight + fishArray[i].getWeight();
		}
		return totalWeight;
	}
	
	// Return a numbered list with information about every fish in the school.
	@Override
	public String toString() {
		
		String string = "";
		String[] stringArr = new String[numFish];
		
		for (int i = 0; i < numFish; ++i)
		{
			stringArr[i] = i + 1 + ". " + fishArray[i].getName() 
					+ ", " + fishArray[i].getSpecies() + ", " 
					+ fishArray[i].getWeight() + " lb\n";
			string = string + stringArr[i];
		}
		
		return string;
		
// Another method:		
//		StringBuilder schoolInfo = new StringBuilder();
//		
//		// For each fish, append its number, info, and a newline character.
//		for (int idx = 0; idx < numFish; ++idx) {
//			Fish fish = fishArray[idx];
//			schoolInfo.append(idx + 1 + ". ");
//			schoolInfo.append(fish.toString());
//			schoolInfo.append("\n");
//		}
//		
//		// Remove the final newline character so an extra line is not printed 
//		// to the console when printing the String with System.out.println.
//		if (schoolInfo.length() > 0) {
//			schoolInfo.deleteCharAt(schoolInfo.length() - 1);
//		}
		
//		return schoolInfo.toString();
		
	}
}
