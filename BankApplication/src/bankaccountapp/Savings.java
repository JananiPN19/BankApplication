package bankaccountapp;

public class Savings extends Account {
	//List properties specific to a savings account.
	private int safetyDepositBoxID,safetyDepositBoxKey;
	
	//Constructor to initialize savings account properties.
	public Savings(String name,String sSN,double initDeposit) {
		super(name,sSN,initDeposit);
		accountNumber = "1" + accountNumber;
		//set the safety deposit box
		setSafetyDepositBox();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
	}
	
	//List any methods specific to savings account.
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Savings");
		super.showInfo();
		System.out.println("Savings Account features");
		System.out.println(
				"  Safety Deposit Box ID:  "+ safetyDepositBoxID + "\n" +
		       "  Safety Depsoit Box Key: "+safetyDepositBoxKey 
				);
	}

}
