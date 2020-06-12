package jrJava.multiThread2;

public class Dispatcher {

	public static void main(String[] args) {

		Calculator calculator = new Calculator();
		
		Task1 task1 = new Task1();
		task1.setCalculator(calculator, 1);
		Thread t1 = new Thread(task1);

		Task2 task2 = new Task2();
		task2.setCalculator(calculator, 1);
		Thread t2 = new Thread(task2);

		t1.start();
		t2.start();

	}

}
