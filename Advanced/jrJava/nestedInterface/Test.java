package jrJava.nestedInterface;

public class Test {

	public static void main(String[] args) {
		MarketWatcher mw = MarketWatcher.getInstance();

		Client c1 = new Client(mw, 101);
		Client c2 = new Client(mw, 102);
		Client c3 = new Client(mw,  103);

		mw.hasBecomeReady();

		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		mw.hasDetectedStatusChange("AAPL + $8");
	}

}
