package POSsystem.People;

import java.util.Scanner;

import POSsystem.ItemInformationSystem.ItemDB;
import POSsystem.SalesSystem.POS;

public class Cashier {
   Customer customer;
   POS pos=new POS();
   ItemDB db;
   
   Scanner scan=new Scanner(System.in);
   
   public void addMileage(Customer customer)
   {
	   int old_mileage=customer.getMileage();
	   int new_mileage=pos.getTotalPrice()/10;
	   customer.setMileage(old_mileage+new_mileage);
   }
   
   public Cashier()
   {
   }
   
   public void connectDB(ItemDB db)
   {
	  this.db=db;
   }
   
   public void update()
   {
	   db.updateDB(customer.getDrinkNumber(), customer.getFoodNumber(), customer.getFruitNumber());
	   System.out.println("***********************************");
	   System.out.println("            �ܿ� ��ǳ ���                                ");
	   db.remainDrink(customer.getDrinkNumber());
	   db.remainFood(customer.getFoodNumber());
	   db.remainFruit(customer.getFruitNumber());
	   System.out.println("***********************************");
   }
   
   public void needBag()
   {
	   int need;
	   System.out.println("������ ��Ƶ帱���??");
	   System.out.println("1.�� 2.�ƴϿ�");
	   need=scan.nextInt();
	   if(need==1)
	   {
		   System.out.println("������ ��Ƶ帮�ڽ��ϴ�.");
	   }
   }
   
   public void needReceipt()
   {
	   int need;
	   System.out.println("1.�� 2.�ƴϿ�");
	   need=scan.nextInt();
	   if(need==1)
	   {
		   pos.printReceipt();
	   }
	   else
	   {
		   System.out.println("������ �����帮�ڽ��ϴ�!");
	   }
   }
   
   public void askPaymentInfo()
   {
	   int type;
	   int need;
	   boolean flag=true;
	   
	   while(flag)
	   {
		   if(customer.getMember())
		   {
			   System.out.println("�ŷ� ����� ����ּ���!");
			   System.out.println("1.���� 2.ī�� 3.���ϸ���");
			   type=scan.nextInt();	   
			   System.out.println(pos.getTotalPrice()+"�� �Դϴ�!");
	   
			   switch(type)
			   {
			   case 1:
				   System.out.println("���� ������ �ص帱���?");
				   needReceipt();
				   needBag();
				   update();
				   addMileage(customer);
				   showUpdateMileage(customer);
				   flag=false;
				   break;
			   case 2:
				   System.out.println("ī�� �޾ҽ��ϴ�.");
				   System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				   System.out.println("������ �帱���?");
				   needReceipt();
				   needBag();
				   update();
				   addMileage(customer);
				   showUpdateMileage(customer);
				   flag=false;
				   break;
			   case 3:
				   if(pos.getTotalPrice()>customer.getMileage())
				   {
					   System.out.println("���ϸ����� �����մϴ�.");
				   }
				   else
				   {
					   System.out.println("���ϸ����� ����� �Ϸ�Ǿ����ϴ�.");
					   customer.setMileage(customer.getMileage()-pos.getTotalPrice());
					   needReceipt();
					   needBag();
					   update();
					   flag=false;
				   }
				   break;
			   }			   
		   }
		   else
		   {
			   System.out.println("�ŷ� ����� ����ּ���!");
			   System.out.println("1.���� 2.ī��");
			   type=scan.nextInt();
	   
			   System.out.println(pos.getTotalPrice()+"�� �Դϴ�!");
	   
			   switch(type)
			   {
			   case 1:
				   System.out.println("���� ������ �ص帱���?");
				   needReceipt();
				   needBag();
				   update();
				   addMileage(customer);
				   showUpdateMileage(customer);
				   need=scan.nextInt();
			   case 2:
				   System.out.println("ī�� �޾ҽ��ϴ�.");
				   System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				   System.out.println("������ �帱���?");
				   needReceipt();
				   needBag();
				   update();
				   addMileage(customer);
				   showUpdateMileage(customer);
				   flag=false;
			   }		   
		   }
	   }
	   
   }
   
   public void treeatCustomer(Customer customer)
   {
      this.customer=customer;
      System.out.println("������� �մ�!");
   }
   
   public void isMember()
   {
      int member=0;
      System.out.println("ȸ�� �̽Ű���??");
      System.out.println("1.ȸ�� 2.��ȸ��");
      member=scan.nextInt();
      switch(member)
      {
      case 1:
         customer.setMember();
         break;
      case 2:
         customer.setNonMember();
         break;   
      }        
   }
   
   public void showUpdateMileage(Customer customer)
   {
	   System.out.println("���� �ݾ��� 10%�� ���ϸ����� �����Ǿ����ϴ�.");
	   System.out.println("���� ���ϸ���:"+customer.getMileage());
   }
   
   public void service()
   {
	   System.out.println("����� �帮�ڽ��ϴ�!");
	   isMember();
	   pos.setDrinkNumber(customer.getDrinkNumber());
	   pos.setFoodNumber(customer.getFoodNumber());
	   pos.setFruitNumber(customer.getFruitNumber());
	   pos.setPrice();
	   
	   pos.calculatePrice();//��� ��
	   askPaymentInfo();
   }
}