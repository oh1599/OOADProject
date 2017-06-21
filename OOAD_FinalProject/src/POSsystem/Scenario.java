package POSsystem;

import POSsystem.ItemInformationSystem.ItemDB;
import POSsystem.People.*;

public class Scenario {
	public static void main(String[] args)
	{
		ItemDB db=new ItemDB();
		db.initializeDB();
		
		Customer customer1=new Customer("Sam");
		customer1.buyItem();
		
		Cashier cashier=new Cashier();
		cashier.connectDB(db);
		
		customer1.askService(cashier);
		cashier.treeatCustomer(customer1);
		
		cashier.service();
		
		
//		
//		Customer customer2=new Customer("Kin");
//		customer2.buyItem();
//		
//		customer2.askService(cashier);
//		cashier.treeatCustomer(customer2);
//		
//		cashier.service();
	}
}
