package jrJava.usingHashMap;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MapOfMap {

	public static void main(String[] args) throws Exception {
		
		Map<Integer, Map<String, Integer>> mmap = new HashMap<Integer, Map<String, Integer>>();
		
		Scanner scanner = new Scanner(new File("jrJava/hashMap_using/data2.txt"));
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			Map<String, Integer> map = parse(line);
			Integer key = map.get("ID");
			mmap.put(key, map);
		}

		printMap(mmap);
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
	
	
	public static void printMap(Map<Integer, Map<String, Integer>> mapOfMaps){
		
		Iterator<Integer> iter1 = mapOfMaps.keySet().iterator();
		while(iter1.hasNext()){
			Integer key1 = iter1.next();
			Map<String, Integer> eachMap = mapOfMaps.get(key1);
			Iterator<String> iter2 = eachMap.keySet().iterator();
			
			while(iter2.hasNext()){
				String key2 = iter2.next();
				Integer value = eachMap.get(key2);
				System.out.print(key2 + ":" + value + "  ");
			}
			System.out.println(); 
		}
	}
	
}














