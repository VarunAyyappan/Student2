package jrJava.multiThread2;

public class Calculator {

	int sum = 0;

	public synchronized void calculateSum () {
		
		//int sum = 0;
		
		for (int i=1; i<=10; i++) {

			sum += i;
			long tid = Thread.currentThread().getId();
			System.out.println(tid + " : sum = " + sum);
			
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
	
	public synchronized void calculateSquareSum () {

		//int sum = 0;

		for (int i=1; i<=10; i++) {

			sum += i*i;
			long tid = Thread.currentThread().getId();
			System.out.println(tid + " : sum = " + sum);

			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
