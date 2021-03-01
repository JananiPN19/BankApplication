package bankaccountapp;

public abstract class Account implements IBaseRate {
	//List common properties for Checking and Savings Accounts.
	private String name,sSN;
	protected String accountNumber;
	private static int index = 10000;
	private double balance;
	protected double rate;		
	
	//Constructor to set base properties and initialize the account.
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
		//set account number.
		index++;
		this.accountNumber = setAccountNumber();
		//set the account rate
		setRate();
	}
	//Method for setting account number.
	private String  setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN+uniqueID+randomNumber;
	}
	
	public abstract void setRate();
	
	//Calculating Compound Interest
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance += accruedInterest;
		System.out.println("Accrued Interest: $"+accruedInterest);
		printBalance();
	}
	
	//List common methods.
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Amount $"+amount+" is deposited in ACCNO "+accountNumber);
		printBalance();
	}
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("Amount $"+amount+" is debited from ACCNO "+accountNumber);
		printBalance();
	}
	public void transfer(String toWhere, double amount) {
		balance -= amount;
		System.out.println("Transferring $"+amount+" to "+toWhere+"....");
		printBalance();
	}
	public void printBalance() {
		System.out.println("Your Current Balance is $"+balance);
	}
	public void showInfo() {
		System.out.println(
				"NAME: "+name+"\n"+
		        "ACCOUNT NUMBER: "+accountNumber+"\n"+
				"BALANCE: $"+balance+"\n"+
		        "RATE: "+rate+"%"
				);
	}

}
