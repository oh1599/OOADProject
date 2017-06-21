package POSsystem.ItemInformationSystem;

import POSsystem.ItemInformationSystem.Item.*;

public class ItemInformation {
	
	public int getDrinkPrice()
	{
		return Drink.getPrice();
	}
	public int getFoodPrice()
	{
		return Food.getCount();
	}
	public int getFruitPrice()
	{
		return Fruit.getPrice();
	}
	
}
