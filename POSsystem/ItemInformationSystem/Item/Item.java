package POSsystem.ItemInformationSystem.Item;

public class Item {
	static int price;
	static int count;
	public static int getCount()
	{
		return count;
	}
	public static void setCount(int count)
	{
		Item.count=count;
	}
	public static int getPrice()
	{
		return price;
	}
}
