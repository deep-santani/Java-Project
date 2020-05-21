import java.util.Scanner;

class BankAccount
{
  int balance;
  int previousTransection;
  String customerName;
  String customerId;

  public BankAccount(String cname,String cid)
  {
      customerName=cname;
      customerId=cid;
  }

  void deposit(int amount)
  {
      if(amount!=0)
      {
          balance=balance+amount;
          previousTransection=amount;
          System.out.println("Deposit Successfully!!!!");  
      }
  }
  void withdraw(int amount)
  {
    if(amount!=0)
    {
        balance=balance-amount;
        previousTransection=-amount;
       System.out.println("Withdraw Successfully!!!!");
    }
  }
  void getPreviousTransection()
  {
      if(previousTransection>0)
      {
          System.out.println("Deposited: "+previousTransection);
      }
      else if(previousTransection<0)
      {
          previousTransection=-previousTransection;
          System.out.println("Withdrawn: "+previousTransection);
      }
      else
      {
          System.out.println("No Transection Accoured");
      }
  }
  void showMenu()
  {
     int option='\0';
     Scanner scanner = new Scanner(System.in);

     System.out.println("\nWelcome "+customerName);
     System.out.println("Your ID is "+customerId+"\n");

     do
     {

         System.out.println("1. Chcek Balance");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Previous Transection");
         System.out.println("5. Exit\n\n");
         System.out.println("*****************************************************************");
         System.out.println("Enter an option");
         System.out.println("*****************************************************************");
         option=scanner.nextInt();
         System.out.println("\n");

         switch(option)
         {
          case 1:
                System.out.println("----------------------------------------------------------");
                System.out.println("Balance = "+balance+"\n");
                System.out.println("----------------------------------------------------------");
                break;
          case 2:
                System.out.println("----------------------------------------------------------");
                System.out.println("Enter An Amount to Deposit");
                System.out.println("----------------------------------------------------------");
                int amount=scanner.nextInt();
	              if(amount<=0)
	              {
	                System.out.println("Deposit Not Possible Myabe you Entered Wrong Amount");
	              }
	              else
	              {
                 deposit(amount);
	              }
                System.out.println("\n");
                break;
        case 3:
                System.out.println("----------------------------------------------------------");
                System.out.println("Enter An Amount to Withdraw");
                System.out.println("----------------------------------------------------------");
                int amount2=scanner.nextInt();
                if(amount2 > 0)
	              {
	                if(amount2 <= balance)
	                {
                    withdraw(amount2);
                  }
	                else
	                {
	                  System.out.println("Insufficient Balance");
	                }
	              }
	              else
	              {
	                System.out.println("Withdraw not possible Maybe You entered Negative Amount");
	              }
                System.out.println("\n");
                break;
        case 4:
                System.out.println("----------------------------------------------------------");
                getPreviousTransection();
                System.out.println("----------------------------------------------------------"+"\n");
                break;
        case 5:
                System.out.println("************************************************************");
                break;
        default :
                System.out.println("Invalid Option!Please enter again");
                break;

       }   
     }
     while(option !=5);
     System.out.println("Thank-You for our Services");
  }
}

class BankingApplication 
{
    public static void main(String[] args) 
    {
      BankAccount obj1=new BankAccount("ABC","AB0001");
      obj1.showMenu();
    }
}