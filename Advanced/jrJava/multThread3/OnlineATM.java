package jrJava.multThread3;

public class OnlineATM  implements Runnable  {

	public BankAccount account;

	public void setBankAcount (BankAccount account) {
		this.account = account;
	}

	public void withdraw () {
		double amount = account.getBalance();
		boolean result = account.withdraw(amount);
		
		if (result) {
			System.out.println("$" + amount + " was succesfully transfered to your offshore account.");
		}
		else {
			System.out.println("It was declined.");
		}
	}

	public void run() {
		boolean result = account.withdraw(1000000);
		if (result)
			System.out.println("$" + 1000000 + " withdrawed.");
		else
			System.out.println("Transaction failed");
	}

}
