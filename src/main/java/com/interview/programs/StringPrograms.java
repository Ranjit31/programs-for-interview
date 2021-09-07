package com.interview.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringPrograms {

	public static void main(String[] args) {
		
		System.out.println("******************************");
		System.out.println("==========find the largest String===========");
		
		ArrayList<String> randomStrings = new ArrayList<>();
		randomStrings.add("ranjit");
		randomStrings.add("raja");
		randomStrings.add("rajshekhar reddy");
		randomStrings.add("ravi-teja");
		
		Optional<String> Largest = randomStrings.stream()
				.sorted((e1, e2) -> e1.length() > e2.length() ? -1 : 1).findFirst();
		
		System.out.println(Largest.get());
		
		System.out.println("******************************");
		System.out.println("==========to remove i (only 4th index) from string mission===========");
		
		String a = "mission";
		StringBuilder sb = new StringBuilder(a);
		System.out.println(sb.deleteCharAt(4));
		
		System.out.println("******************************");
		System.out.println("==========find the duplicate elements===========");
		List<String> strList = Arrays.asList("Dev", "Ram", "Rajesh", "Abhay", "Ram", "Dev", "Abhay", "abhay");
		
		Set<String> uniqueElements = new HashSet<>();
		List<String> dupicateList = strList.stream().filter(i -> !uniqueElements.add(i)).collect(Collectors.toList());
		dupicateList.stream().forEach(System.out :: println);
		
		System.out.println("******************************");
		System.out.println("==========find the unique elements===========");
		
		Set<String> uniqueElements1 = new HashSet<>();
		List<String> uniqueList = strList.stream().filter(i -> uniqueElements1.add(i)).collect(Collectors.toList());
		uniqueList.stream().forEach(System.out :: println);
		
		System.out.println("******************************");
		System.out.println("==========String immutable===========");
		String s = "Rajesh";
		s = "Ranjit";
		System.out.println("String Object "+s.toString());
 	}

}