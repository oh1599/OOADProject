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
	   System.out.println("            잔여 상풍 목록                                ");
	   db.remainDrink(customer.getDrinkNumber());
	   db.remainFood(customer.getFoodNumber());
	   db.remainFruit(customer.getFruitNumber());
	   System.out.println("***********************************");
   }
   
   public void needBag()
   {
	   int need;
	   System.out.println("봉투에 담아드릴까요??");
	   System.out.println("1.예 2.아니오");
	   need=scan.nextInt();
	   if(need==1)
	   {
		   System.out.println("봉투에 담아드리겠습니다.");
	   }
   }
   
   public void needReceipt()
   {
	   int need;
	   System.out.println("1.예 2.아니오");
	   need=scan.nextInt();
	   if(need==1)
	   {
		   pos.printReceipt();
	   }
	   else
	   {
		   System.out.println("영수증 버려드리겠습니다!");
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
			   System.out.println("거래 방식을 골라주세요!");
			   System.out.println("1.현금 2.카드 3.마일리지");
			   type=scan.nextInt();	   
			   System.out.println(pos.getTotalPrice()+"원 입니다!");
	   
			   switch(type)
			   {
			   case 1:
				   System.out.println("현금 영수증 해드릴까요?");
				   needReceipt();
				   needBag();
				   update();
				   addMileage(customer);
				   showUpdateMileage(customer);
				   flag=false;
				   break;
			   case 2:
				   System.out.println("카드 받았습니다.");
				   System.out.println("결제가 완료되었습니다.");
				   System.out.println("영수증 드릴까요?");
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
					   System.out.println("마일리지가 부족합니다.");
				   }
				   else
				   {
					   System.out.println("마일리지로 계산이 완료되었습니다.");
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
			   System.out.println("거래 방식을 골라주세요!");
			   System.out.println("1.현금 2.카드");
			   type=scan.nextInt();
	   
			   System.out.println(pos.getTotalPrice()+"원 입니다!");
	   
			   switch(type)
			   {
			   case 1:
				   System.out.println("현금 영수증 해드릴까요?");
				   needReceipt();
				   needBag();
				   update();
				   addMileage(customer);
				   showUpdateMileage(customer);
				   need=scan.nextInt();
			   case 2:
				   System.out.println("카드 받았습니다.");
				   System.out.println("결제가 완료되었습니다.");
				   System.out.println("영수증 드릴까요?");
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
      System.out.println("어서오세요 손님!");
   }
   
   public void isMember()
   {
      int member=0;
      System.out.println("회원 이신가요??");
      System.out.println("1.회원 2.비회원");
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
	   System.out.println("구매 금액의 10%가 마일리지에 적립되었습니다.");
	   System.out.println("현재 마일리지:"+customer.getMileage());
   }
   
   public void service()
   {
	   System.out.println("계산해 드리겠습니다!");
	   isMember();
	   pos.setDrinkNumber(customer.getDrinkNumber());
	   pos.setFoodNumber(customer.getFoodNumber());
	   pos.setFruitNumber(customer.getFruitNumber());
	   pos.setPrice();
	   
	   pos.calculatePrice();//계산 끝
	   askPaymentInfo();
   }
}