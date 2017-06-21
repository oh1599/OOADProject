package POSsystem.ItemInformationSystem;

import POSsystem.ItemInformationSystem.Item.*;

public class ItemInformation {
	///
	Drink drink=new Drink();
	Food food=new Food();
	Fruit fruit=new Fruit();
	
	public int getDrinkPrice()
	{
		return drink.getPrice();
	}
	public int getFoodPrice()
	{
		return food.getPrice();
	}
	public int getFruitPrice()
	{
		return fruit.getPrice();
	}
	
}
