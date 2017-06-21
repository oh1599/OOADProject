package POSsystem.ItemInformationSystem;

import POSsystem.ItemInformationSystem.Item.*;
public class ItemDB {
	
	int totalDrinkNumber=100;
	int totalFoodNumber=100;
	int totalFruitNumber=100;
	
	public void initializeDB()
	{
		Drink.setCount(totalDrinkNumber);
		Food.setCount(totalFoodNumber);
		Fruit.setCount(totalFruitNumber);
	}
	public void updateDB(int drink,int food,int fruit)
	{
		totalDrinkNumber-=drink;
		totalFoodNumber-=food;
		totalFruitNumber-=fruit;
		Drink.setCount(totalDrinkNumber-drink);
		Food.setCount(totalFoodNumber-food);
		Fruit.setCount(totalFruitNumber-fruit);
	}
	public void remainDrink(int num)
	{
		int res=Drink.getCount()-num;
		System.out.println("���� ����� ����:"+res);
	}
	public void remainFood(int num)
	{
		int res=Food.getCount()-num;
		System.out.println("���� ���� ����:"+res);
	}
	public void remainFruit(int num)
	{
		int res=Fruit.getCount()-num;
		System.out.println("���� ���� ����:"+res);
	}
}
