package POSsystem.SalesSystem;

import POSsystem.ItemInformationSystem.*;

public class POS {
	ItemInformation info=new ItemInformation();

	int drinkNumber=0;
	int foodNumber=0;
	int fruitNumber=0;
	
	int drinkPrice;
	int foodPrice;
	int fruitPrice;

	
	int totalPrice=drinkPrice+foodPrice+fruitPrice;
	
	public void setPrice()
	{
		drinkPrice=info.getDrinkPrice()*drinkNumber;
		foodPrice=info.getFoodPrice()*foodNumber;
		fruitPrice=info.getFruitPrice()*fruitNumber;
		
		totalPrice=drinkPrice+foodPrice+fruitPrice;
	}
	
	public int getTotalPrice()
	{
		return totalPrice;
	}
	
	public void setDrinkNumber(int number)
	{
		this.drinkNumber=number;
	}
	public void setFoodNumber(int number)
	{
		this.foodNumber=number;
	}
	public void setFruitNumber(int number)
	{
		this.fruitNumber=number;
	}
	
	public void calculatePrice()
	{
		if(drinkNumber>0)
		{
			System.out.println("음료수:"+drinkNumber+"개 가격:"+drinkPrice+"원");
		}
		if(foodNumber>0)
		{
			System.out.println("음식:"+foodNumber+"개 가격:"+foodPrice+"원");
		}
		if(fruitNumber>0)
		{
			System.out.println("과일:"+fruitNumber+"개 가격:"+fruitPrice+"원");
		}
		System.out.println("총 금액: "+totalPrice);
	}
	
	public void printReceipt()
	{
		System.out.println("*************************************");
		System.out.println("음료수:"+drinkNumber+"개 가격:"+drinkPrice+"원");
		System.out.println("음식:"+foodNumber+"개 가격:"+foodPrice+"원");
		System.out.println("과일:"+fruitNumber+"개 가격:"+fruitPrice+"원");
		System.out.println("총 금액: "+totalPrice);
		System.out.println("*************************************");
	}
}
