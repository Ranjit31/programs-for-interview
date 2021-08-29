package com.interview.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayPrograms {

	public static void main(String[] args) {
		
		System.out.println("******************************");
		System.out.println("=========Second Highest element from Array=========");
		
		Integer[] al = {32, 35, 27, 86, 95, 31, 77, 55};
		Arrays.sort(al);
		System.out.println(al[al.length - 2]);
		
		System.out.println("******************************");
		System.out.println("=========Second Highest element from List=========");
		
		Integer[] alist = {32, 35, 27, 86, 95, 31, 77, 55};
		List<Integer> list = Arrays.asList(alist);
		Collections.sort(list);
		System.out.println(list.get(list.size() - 2));

	}

}
