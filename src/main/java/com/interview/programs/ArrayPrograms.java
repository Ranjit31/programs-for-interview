package com.interview.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		
		System.out.println("******************************");
		System.out.println("=========Convert Array to Stream=========");
		Stream<Integer> streamInt = Arrays.stream(al);
		streamInt.forEach(x -> System.out.println(x));
		
		System.out.println("******************************");
		System.out.println("=========Summary statistics from List=========");
		
		List<Integer> numList = Arrays.asList(5, 10, 15, 25, 30, 45);
		
		IntSummaryStatistics  summaryStatistics = numList.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("Average "+summaryStatistics.getAverage());
		System.out.println("Sum "+summaryStatistics.getSum());
		System.out.println("Max "+summaryStatistics.getMax());
		System.out.println("Min "+summaryStatistics.getMin());
		System.out.println("Count "+summaryStatistics.getCount());
		
		System.out.println("******************************");
		System.out.println("=========Use of collectors=========");
		
		List<String> strList = Arrays.asList("abc", "qr", "xyz", "", "st", "");
		List<String> filtered = strList.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered Str "+filtered);
		
		String combined = strList.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(","));
		System.out.println("Combined Str "+combined);
		
		System.out.println("******************************");
		System.out.println("=========Parallel stream=========");
		
		Long cnt = strList.parallelStream().filter(str -> str.isEmpty()).count();
		System.out.println("Count of empty string using parallel stream "+cnt);
		
		System.out.println("******************************");
		System.out.println("=========Print 10 random numbers in ascending order=========");
		
		Random random = new Random();
		random.ints().limit(10).sorted().forEach(System.out :: println);
		
		System.out.println("******************************");
		System.out.println("=========Combine 2 lists and remove duplicates=========");
		
		List<Integer> listOne = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> listTwo = Arrays.asList(6,7,8,9);
		List<Integer> combinedList = Stream.of(listOne, listTwo).flatMap(x -> x.stream())
				.distinct().collect(Collectors.toList());
		
		System.out.println(combinedList);
		
		
	}

}
