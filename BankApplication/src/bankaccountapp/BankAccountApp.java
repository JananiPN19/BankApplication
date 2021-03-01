package bankaccountapp;

import java.util.*;

public class BankAccountApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\t\t\t***********WELCOME TO BANK APPLICATION SYSTEM***********\t\t\t");
		List<Account> accounts = new LinkedList<Account>();
		
		//Read a CSV file and then read account on that data.
		String file = "C:\\Users\\Janani P\\Downloads\\NewBankAccounts.csv";
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for(String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accType = accountHolder[2];
			Double initDeposit = Double.parseDouble(accountHolder[3]);
			if(accType.equals("Savings")) {
				accounts.add(new Savings(name,sSN,initDeposit));
			}
			else if(accType.equals("Checking")) {
				accounts.add(new Checking(name,sSN,initDeposit));
			}
			else {
				System.out.println("Error in Account type");
			}
		}
		for(Account acc: accounts) {
			System.out.println("\n*****************************");
			acc.showInfo();
		}
	}
}
