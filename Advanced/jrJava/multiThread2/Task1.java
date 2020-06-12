package jrJava.multiThread2;

public class Task1 implements Runnable {

	private Calculator calculate;
	private int option;

	public void setCalculator (Calculator calculate, int option) {
		this.calculate = calculate;
		this.option = option;
	}

	public void run () {
		doTask();
	}

	private void doTask() {
		if(option==1) calculate.calculateSum();
		else calculate.calculateSquareSum();
	}

}
