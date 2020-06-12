package jrJava.multiThread1;

public class Task2 implements Runnable {

	public void run() {
		doTask();
	}

	public void doTask () {

		int sum = 0;
		
		for(int i=1; i<=10; i++) {
			sum += (i^2);
			System.out.println(sum);
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
		}

	}

}
