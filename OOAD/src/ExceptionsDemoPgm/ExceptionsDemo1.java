package ExceptionsDemoPgm;

class BalanceTooLowException extends Exception {
	private double howLow;

	public BalanceTooLowException(double amount, String message) {
		super(message);
		howLow = amount;
	}

	public String toString() {
		return "Balance Too Low: " + howLow;
	}

}

class BankAccount {
	public static final double MINIMUM = 100;
	private String acctId;
	private double balance = MINIMUM;

	public BankAccount(String acctId) {
		this.acctId = acctId;
	}

	public double withdraw(double amount) throws BalanceTooLowException {
		if ((balance - amount) < MINIMUM)
			throw new BalanceTooLowException(balance - amount,
					"Balance less than minimum");

		balance -= amount;
		return amount;
	}

	public void deposit(double amount) throws Exception {
		if (amount < 0)
			throw new Exception("Cannot deposit negative amount");

		balance += amount;
	}

	public double getBalance() {
		return balance;
	}
}

/**
 * Handling Exceptions
 * 
 * @author apar.sri
 *
 */
public class ExceptionsDemo1 {

	public static void transactions() throws Exception {

		BankAccount myAcct = new BankAccount("A1234");

		try {
			myAcct.withdraw(50);
		} catch (BalanceTooLowException e) {
			System.out.println(e);
		} finally {

			System.out.println(myAcct.getBalance());
		}
		myAcct.deposit(1000.00);
	}

	public static void main(String[] args) {

		try {
			transactions();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
