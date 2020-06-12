package jrJava.nestedInterface;

import java.util.ArrayList;

public class MarketWatcher {

	// fields
	// methods;

	private ArrayList<Callback> callbacks;

	private static MarketWatcher mw;
	
	public static MarketWatcher getInstance() {
		if(mw==null)
			mw = new MarketWatcher();

		return mw;
	}

	private MarketWatcher() {
		callbacks = new ArrayList<Callback>();
	}

	public void addCallback(Callback callback) {
		callbacks.add(callback);
	}

	public void removeCallback(Callback callback) {
		callbacks.remove(callback);
	}

	public void hasBecomeReady() {
		for(int i=0; i<callbacks.size(); i++) {
			callbacks.get(i).onReady();
		}
	}

	public void hasDetectedStatusChange(String change) {
		for(int i=0; i<callbacks.size(); i++) {
			callbacks.get(i).onStatusChange(change);
		}
	}

	public interface Callback {
		void onReady();
		void onStatusChange(String change);
	}

}
