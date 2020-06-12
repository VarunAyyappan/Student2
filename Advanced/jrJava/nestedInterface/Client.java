package jrJava.nestedInterface;

public class Client{

	// fields
	// methods(...)

	private int id;

	public Client(MarketWatcher mw, int idIn) {
		mw.addCallback(
			new MarketWatcher.Callback() {
				public void onReady() {
					System.out.println(id + ": MW is ready. I should stand by.");
				}

				public void onStatusChange(String change) {
					System.out.println(id + ": There was a change of"
							+ change + " occured. I should do something about it.");
				}
			}
		);
		id = idIn;
	}

	private class CallbackHelper implements MarketWatcher.Callback{
		public void onReady() {
			System.out.println(id + ": MW is ready. I should stand by.");
		}

		public void onStatusChange(String change) {
			System.out.println(id + ": There was a change of"
					+ change + " occured. I should do something about it.");
		}
	}

}
