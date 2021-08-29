package com.interview.programs;

import java.util.ArrayList;
import java.util.Optional;
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
		
		//Random Execution
		
		Stream<String> st = Stream.iterate("", (str) -> str + "x"); 
		
		System.out.println(st.limit(3).map(str -> str + "y"));
		
		System.out.println("******************************");
		System.out.println("==========to remove i (only 4th index) from string mission===========");
		
		String a = "mission";
		StringBuilder sb = new StringBuilder(a);
		System.out.println(sb.deleteCharAt(4));
		
 	}

}
