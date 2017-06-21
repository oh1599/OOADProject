package POSsystem.ItemInformationSystem.Item;

public class Item {
	int price;
	static int count;
	public static int getCount()
	{
		return count;
	}
	public static void setCount(int count)
	{
		Item.count=count;
	}
	public int getPrice()
	{
		return price;
	}
}
