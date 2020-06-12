package jrJava.usingHashMap;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class CreateMapFromDataFile {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("jrJava/usingHashMap/testResults.txt"));
		String line = scanner.nextLine();
		Map<String, Integer> grades = createMap(line);
		printAll(grades);
	}

	public static Map<String, Integer> createMap(String line){
		StringTokenizer st = new StringTokenizer(line, ",");
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		String token;
		String key;
		Integer value;
		int equalsPos;
		while(st.hasMoreTokens()){
			token = st.nextToken();
			equalsPos = token.indexOf('=');
			key = token.substring(0, equalsPos).trim();
			value = Integer.parseInt(token.substring(equalsPos+1).trim());
			map.put(key, value);
		}
		return map;
	}
	
	public static void printAll(Map<String, Integer> map){
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		String key;
		int value;
		while(iter.hasNext()){
			key = iter.next();
			value = map.get(key);
			System.out.print(key + ":" + value + "  ");
		}
		System.out.println();
	}
	
}




















