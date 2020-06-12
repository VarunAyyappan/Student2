package jrJava.multThread3;

public class BankAccount {

	private double balance = 1000000;
	private boolean isLean = true;

	public double getBalance () {
		return balance;
	}

	public synchronized boolean withdraw (double requestAmount) {
		if (balance==0 || balance<requestAmount) return false;
		
		// check HLS server
		// check ATF server
		// check DEA server
		// check against leans
		// transfer requested amount

		try {
			Thread.currentThread().sleep(200);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		balance -= requestAmount;
		return true;
	}

}