package Week1;

public class BankAccount {
	private double balance;
	private static double interestRate = 0.05; 
	private final double MIN_BALANCE;	
    
	   /**
	      A default constructor - Constructs a bank account with a zero balance.
	   */
	   public BankAccount(){   
	      balance = 0;
	      MIN_BALANCE = 10;
	   }
	   /**
	      Constructs a bank account with a given balance.
	   */
	   public BankAccount(double initialBalance){   
	      balance = initialBalance;
	      MIN_BALANCE = 10;
	   }
	   /**
	      Deposits money into the bank account.
	   */
	   public void deposit(double amount){  
	      balance += amount;
	   }

	   /**
	      Withdraws money from the bank account.
	   */
	   public void withdraw(double amount){   
	      if (balance - amount >= MIN_BALANCE)
	    	  balance -= amount;
	   }

	   /**
	      Gets the current balance of the bank account.
	   */
	   public double getBalance()
	   {   
	      return balance;
	   }
	   public static void changeRate(double newRate){
		   interestRate = newRate;
	   }
	   public double getInterestAccrued(){
		   return balance * interestRate;
	   }
	   public static double getInterestRate(){
		   return interestRate;
	   }
	   
	public static void main(String[] args) {
		
		// Create an an instance of a BankAccount 
		
		BankAccount acct1 = new BankAccount(); //default constructor will be called
		
		System.out.println(acct1.getBalance());
		
		acct1.deposit(150.00);
		System.out.println(acct1.getBalance());
		
		acct1.withdraw(100.00);
		System.out.println(acct1.getBalance());
		
		// Create an another instance of a BankAccount
		
		BankAccount acct2 = new BankAccount(acct1.getBalance());
		
		
		System.out.println(acct2.getBalance());
		
		System.out.println(BankAccount.getInterestRate());
		
		System.out.println(acct2.getInterestAccrued());
		

	}

}
