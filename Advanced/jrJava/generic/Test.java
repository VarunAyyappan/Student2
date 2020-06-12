package jrJava.generic;

public class Test {

	public static void main(String[] args) {
		/*
		Storage1 s1 = new Storage1();
		s1.setData("necesito matarme");
		String data1 = s1.getData();
		//Integer ref1 = (Integer) data1; -> doesn't work

		Storage2 s2 = new Storage2();
		s2.setData(45);
		Integer data2 = s2.getData();
		//String ref2 = (String) data2; -> doesn't work
		
		Storage3 s3 = new Storage3();
		s3.setData("aaa");
		Object data3 = s3.getData();
		String ref3 = (String) data3;  // will compile, but cause ClassCastException
		*/

		Storage<String> s = new Storage<String>();
		s.setData("aaa"); // s.setData(45);
		// Integer ref = (Integer) s.getData();

		Storage<Integer> s2 =  new Storage<Integer>();
		s2.setData(45);  //s2.setData("aaa");

		MapStorage<Integer, String> map = new MapStorage<Integer, String>();
		map.put(45, "aaa");
		Integer key = map.getKey();
		String value = map.getValue();
	}

}
