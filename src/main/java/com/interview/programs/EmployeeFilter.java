package com.interview.programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class EmployeeFilter {

	public static void main(String[] args) {

		ArrayList<Employee> empArrayList  = new ArrayList<>();
		empArrayList.add(new Employee(1,"ravi","finance", 20000, 29));
		empArrayList.add(new Employee(2,"sohum","finance", 22000, 34));
		empArrayList.add(new Employee(3,"ramlal","hr", 20000, 54));
		empArrayList.add(new Employee(4,"tarak","account", 19000, 44));
		empArrayList.add(new Employee(5,"jethalal","hr", 18000, 19));
		empArrayList.add(new Employee(6,"shahrukh","account", 15000, 30));
		empArrayList.add(new Employee(7,"ravi","finance", 20000, 29));


		System.out.println("========Employee names with age > 25========");
		List<String> filteredEmployee = empArrayList.stream()
				.filter(e1 -> e1.getAge() > 25)
				.map(Employee::getName)
				.collect(Collectors.toList());
		filteredEmployee.forEach(empName -> System.out.println(empName));


		System.out.println("========Number of employees with age 20======");
		Long empCount = empArrayList.stream()
				.filter(emp -> emp.getAge() == 20)
				.count();
		System.out.println("Number of Employees with age 20: "+empCount);


		System.out.println("=========Find the employees with name ravi-rana========");
		Optional<Employee> e1 = empArrayList.stream()
				.filter(emp -> emp.getName().equalsIgnoreCase("ravi-rana"))
				.findAny();

		if(e1.isPresent())
			System.out.println(e1.get());


		System.out.println("========Find the maximum age of the employee========");
		OptionalInt max = empArrayList.stream()
				.mapToInt(Employee::getAge)
				.max();

		if(max.isPresent())
			System.out.println("maximum age for the employee is: "+max.getAsInt());

		System.out.println("=========Group them by employee Name=========");

		Map<String, List<Employee>> map = empArrayList.stream()
				.collect(Collectors.groupingBy(Employee :: getName));
		
		map.forEach((empName, employeeListTemp) -> System.out.println("Name "+empName+"====>"+employeeListTemp));
		
		System.out.println("=========Group them by employee department=========");
		
		Map<String, List<Employee>> employeeByDept= empArrayList.stream()
				.collect(Collectors.groupingBy(Employee :: getDepartment));

		employeeByDept.forEach((dept, employeeList) -> System.out.println("Dept "+dept+"=====>"+employeeList));
		
		System.out.println("=========Join Employee Names with , =========");

		List<String> employeeNames = empArrayList.stream()
				.map(Employee::getName)
				.collect(Collectors.toList());
		
		String empoyeeNameStr = String.join(",", employeeNames);
		System.out.println("Employees are: "+empoyeeNameStr);
		
		System.out.println("=========Sort all employees on the basis of age=========");
		
		empArrayList.sort((e,e2) -> e.getAge() - e2.getAge());
		empArrayList.forEach(System.out::println);
		
		System.out.println("==========to remove i (only 4th index) from string mission===========");
		
		String a = "mission";
		StringBuilder sb = new StringBuilder(a);
		System.out.println(sb.deleteCharAt(4));
		
		System.out.println("=========Sort all employees on the basis of id=========");
		List<Employee> sortedList = empArrayList.stream()
				.sorted(Comparator.comparingInt(Employee :: getId)).collect(Collectors.toList());
		
		sortedList.forEach(System.out :: println);
		
		System.out.println("=========Sort all employees in desending on the basis of id=========");
		List<Employee> reverseSortedList = empArrayList.stream()
				.sorted(Comparator.comparingInt(Employee :: getId).reversed()).collect(Collectors.toList());
		
		reverseSortedList.forEach(System.out :: println);
	}

}
