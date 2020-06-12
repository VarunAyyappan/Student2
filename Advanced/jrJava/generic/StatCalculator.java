package jrJava.generic;

public class StatCalculator<E extends Number> {
	private E[] values;

	public void setData(E[] values) {
		this.values = values;
	}

	public E getData(int index) {
		if(index>values.length-1)
			throw new IndexOutOfBoundsException();

		return values[index];
	}
	
	public E min() {
		E min = values[0];

		for(int i=1; i<=values.length; i++) {
			if(values[i].doubleValue() < min.doubleValue())
				min = values[i];
		}

		return min;
	}
	
	public double getAverage() {
		double sum = 0.0;

		for(int i = 0; i<values.length; i++)
			sum += values[i].doubleValue();

		return sum/values.length;
	}
}
