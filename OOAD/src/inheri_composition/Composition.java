package inheri_composition;

class Manager {
	private String name;
	//Manager has AdminStaff and Funds-has-a
	private AdminStaff secretary;
	private Funds budget;
	private String projectName;

	public Manager() {
	}

	public Manager(String name, AdminStaff secretary, String fundId,
			double allocation) {
		this.name = name;
		//can instantiate obj of type Funds here
		budget = new Funds(fundId, allocation);
		this.secretary = secretary;
		secretary.manageBudget(budget);
	}

	public String yearlyReport(String projectName) {

		String report = new String("Yearly Report: ");
		report = report + projectName;
		report = report + secretary.budgetDetails(budget.getFundId());
		return report;
	}
}

class Funds {

	private String fundId;
	private double amount;
	private String expenseDetails;

	public Funds(String fundId, double amount) {
		this.fundId = fundId;
		this.amount = amount;
	}

	public String getFundId() {
		return fundId;
	}

	@Override
	public String toString() {
		return "Funds ["
				+ (fundId != null ? "fundId=" + fundId + ", " : "")
				+ "amount="
				+ amount
				+ ", "
				+ (expenseDetails != null ? "expenseDetails=" + expenseDetails
						: "") + "]";
	}

}

class AdminStaff {
	private String name;
	//AdminStaff has funds
	private Funds fundsToManage;

	public AdminStaff(String name) {
		this.name = name;
	}

	//has-a relation
	public void manageBudget(Funds funds) {

		this.fundsToManage = funds;
	}

	//has-a relation
	public Funds budgetDetails(String fundId) {
		return fundsToManage;
	};
}

public class Composition {

	public static void main(String[] args) {

		AdminStaff staff = new AdminStaff("Jones");
		Manager manager1 = new Manager("Smith", staff, "A123", 100000);

		System.out.println(manager1.yearlyReport("Alpha"));

	}
}