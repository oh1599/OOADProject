package POSsystem.People;

import java.util.Scanner;

public class Customer {
	String name;
	boolean isMember;
	
	int mileage;
	
	int drinkNumber=0;
	int foodNumber=0;
	int fruitNumber=0;
	
	Cashier cashier;
	Scanner scan=new Scanner(System.in);
	
	public void setMileage(int mileage)
	{
		this.mileage=mileage;
	}
	
	public boolean getMember()
	{
		return isMember;
	}
	
	public int getMileage()
	{
		return mileage;
	}
	
	public int getDrinkNumber()
	{
		return drinkNumber;
	}
	
	public int getFoodNumber()
	{
		return foodNumber;
	}
	
	public int getFruitNumber()
	{
		return fruitNumber;
	}
	
	
	public void askService(Cashier cashier)
	{
		this.cashier=cashier;
	}
	
	public void setMember()
	{
		isMember=true;
	}
	public void setNonMember()
	{
		isMember=false;
	}
	
	public Customer()
	{
	}
	
	public Customer(String name)
	{
		this.name=name;
	}
	
	public void buyItem()
	{
		boolean flag=true;
		while(flag)
		{
			int index=0;
			int itemNumber=0;
		
			System.out.println("구매할 아이템을 고르세요");
			System.out.println("1.음료수 2.음식 3.과일 4.구매 종료");
			index=scan.nextInt();
			switch(index)
			{
			case 1:
				System.out.println("수량을 고르세요");
				itemNumber=scan.nextInt();
				drinkNumber+=itemNumber;
				break;
			case 2:
				System.out.println("수량을 고르세요");
				itemNumber=scan.nextInt();
				foodNumber+=itemNumber;
				break;
			case 3:
				System.out.println("수량을 고르세요");
				itemNumber=scan.nextInt();
				fruitNumber+=itemNumber;
				break;
			case 4:
				flag=false;
				break;
			default:
				System.out.println("재입력 해주세요");
				break;
			}
		}
		System.out.println("구매 완료");
		System.out.println("cashier님 계산 해주세요");
	}
	
}
