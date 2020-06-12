package jrJava.multiThread1;

public class Task {

	public static void main(String[] args) {
		
		int sum = 0;
		
		Task2 task2 = new Task2();
		Thread t2 = new Thread(task2);
		t2.start();
		
		Task3 task3 = new Task3();
		Thread t3 = new Thread(task3);
		t3.start();
		
		for(int i=1; i<=10; i++) {
			sum+=i;
			System.out.println(sum);
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		sum = 0;
		
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
