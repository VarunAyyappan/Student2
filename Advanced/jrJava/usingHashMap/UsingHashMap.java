package jrJava.usingHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UsingHashMap {

	public static void main(String[] args) {
		
		Map<String, Integer> grades = new HashMap<String, Integer>();
		
		grades.put("ID", 101);
		grades.put("English", 85);
		grades.put("History", 96);
		grades.put("Spanish", 99);
		grades.put("Math", 95);
		grades.put("PE", 77);
		
		double average = getAverage(grades);
		System.out.println(average);
	}
	
	
	public static double getAverage(Map<String, Integer> map){
		Iterator<String> iter = map.keySet().iterator();
		double sum = 0;
		int num = 0;
		while(iter.hasNext()){
			String key = iter.next();
			if(key.equals("ID")) continue;
			int score = map.get(key);
			sum += score;
			num++;
		} 
		return sum/num;
	}

}








