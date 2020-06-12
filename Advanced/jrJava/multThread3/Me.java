package jrJava.multThread3;

public class Me {

	BankAccount account = new BankAccount();
	OnlineATM atm = new OnlineATM();

	public static void main(String[] args) {

		BankAccount account = new BankAccount();
		OnlineATM atm = new OnlineATM();
		
		atm.setBankAcount(account);

		Thread[] threads = new Thread[10];

		for(int i=0; i<threads.length; i++) {
			threads[i] = new Thread(atm);
		}
		
		for(int i=0; i<threads.length; i++) {
			threads[i].start();
		}
		
	}

}
