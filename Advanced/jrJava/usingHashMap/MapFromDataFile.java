package jrJava.usingHashMap;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MapFromDataFile {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(new File("jrJava/hashMap_using/data.txt"));
		String line = scanner.nextLine();
		Map<String, Integer> map = parse(line);
		System.out.println(getAverage(map));  
	}

	
	public static Map<String, Integer> parse(String line){
		
		StringTokenizer st = new StringTokenizer(line, ",");
		Map<String, Integer> map = new HashMap<String ,Integer>();
		
		while(st.hasMoreTokens()){
			String token = st.nextToken();
			int equalPos = token.indexOf('=');
			String key = token.substring(0, equalPos).trim();
			String value = token.substring(equalPos+1).trim();
			map.put(key, Integer.parseInt(value)); 
		}
		return map;
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
