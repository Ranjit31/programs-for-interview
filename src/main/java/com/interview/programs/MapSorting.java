package com.interview.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapSorting {
	
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);
		
		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		
		System.out.println("Sorting with older implementation");
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
			
		});
		
		for(Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		System.out.println("******************************");
		System.out.println("Sorting with lambda expression");
		
		Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		
		for(Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		System.out.println("******************************");
		System.out.println("Sorting with stream using values");
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out :: println);
		
		System.out.println("******************************");
		System.out.println("Sorting with stream using keys");
		
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out :: println);
	}
}
