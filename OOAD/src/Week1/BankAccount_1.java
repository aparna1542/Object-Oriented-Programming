package Week1;


public class BankAccount_1 {
	String acctId;
	private double balance;
	
	   /**
	      A default constructor - Constructs a bank account with a zero balance.
	   */
	   public BankAccount_1(){
		  acctId = null;
	      balance = 0;
	   }
	   /**
	      Constructs a bank account with a given balance.
	   */
	   public BankAccount_1(String acctId, double balance){   
	      this.acctId = acctId;
	      this.balance = balance;
	      
	   }
	   
	   public void setAcctId (String acctId){
		   this.acctId = acctId;  
	   }
	   public String getAcctId (){
		   return acctId;  
	   }
	   /**
	      Gets the current balance of the bank account.
	   */
	   public double getBalance()
	   {   
	      return balance;
	   }
	   
	   private boolean isAcctIdValid(){
		   for (int i = 0; i < acctId.length(); ++i){
			   char symbol = acctId.charAt(i);
			   if (!Character.isLetterOrDigit(symbol))
				   return false;
		   }
		   return true;
	   }
	   
	public static void main(String[] args) {
		
		// Create an another instance of a BankAccount
		
		BankAccount_1 acct2 = new BankAccount_1("A222",350.00);
		
		System.out.print("AcctId: "+acct2.getAcctId());
		System.out.print(" Valid: "+acct2.isAcctIdValid());
	}

}
