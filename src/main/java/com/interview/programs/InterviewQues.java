package com.interview.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewQues {

	public static void main(String[] args) {
		
		System.out.println("******************************");
		System.out.println("=========find the number of times number/word got repeated=========");
		
		List<Integer> numList = Arrays.asList(5, 3, 2, 3, 5, 19, 8, 19, 5);
		List<String> strList = Arrays.asList("Dev", "Ram", "Rajesh", "Abhay", "Ram", "Dev", "Abhay", "abhay");
		
		Map<String, Long> occurancesCnt = strList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		occurancesCnt.entrySet().forEach(entry -> System.out.println(entry.getKey()+"---------"+entry.getValue()));
		
		System.out.println("******************************");
		
		Map<Integer, Long> occuranceCnt = numList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		occuranceCnt.entrySet().forEach(entry -> System.out.println(entry.getKey()+"---------"+entry.getValue()));
		
		//normal implementation
		System.out.println("******************************");
		
		Map<String, Integer> nameCntMap = new HashMap<>();
		for (String str: strList) {
			if(nameCntMap.containsKey(str)) {
				int cnt = nameCntMap.get(str);
				cnt = cnt + 1;
				nameCntMap.put(str, cnt);
			} else {
				nameCntMap.put(str, 1);
			}
		}
		
		nameCntMap.forEach((key, value) -> System.out.println(key+"---------"+value));
	}

}
