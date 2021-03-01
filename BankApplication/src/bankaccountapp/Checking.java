package bankaccountapp;

public class Checking extends Account {
	//List properties specific to a checking account.
	private int debitCardNumber,debitCardPIN;
	
	//Constructor to initialize checking account properties.
	public Checking(String name, String sSN, double initDeposit) {
		super(name,sSN,initDeposit);
		accountNumber = "2"+accountNumber;
		//set Debit card
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() * .15;
	}
	
	//List any methods specific to checking account.
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random()*Math.pow(10, 12));
		debitCardPIN = (int) (Math.random()*Math.pow(10, 4));
	}
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Checking");
		super.showInfo();
		System.out.println(
				"Checking Account features\n"+
				"  Debit card number: "+debitCardNumber+"\n"+
				"  Debit Card PIN: "+debitCardPIN		
				);
	}
}
