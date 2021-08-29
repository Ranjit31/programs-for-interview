package com.interview.programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmployeeFilter {

	public static void main(String[] args) {

		ArrayList<Employee> empArrayList  = new ArrayList<>();
		empArrayList.add(new Employee(1,"ravi","finance", 20000, 29));
		empArrayList.add(new Employee(2,"sohum","finance", 22000, 34));
		empArrayList.add(new Employee(3,"lion","hr", 20000, 54));
		empArrayList.add(new Employee(4,"tarak","account", 19000, 44));
		empArrayList.add(new Employee(5,"jethalal","hr", 18000, 19));
		empArrayList.add(new Employee(6,"shahrukh","account", 15000, 30));
		empArrayList.add(new Employee(7,"zebra","finance", 20000, 29));

		System.out.println("******************************");
		System.out.println("========Employee names with age > 25========");
		List<String> filteredEmployee = empArrayList.stream()
				.filter(e1 -> e1.getAge() > 25)
				.map(Employee::getName)
				.collect(Collectors.toList());
		filteredEmployee.forEach(empName -> System.out.println(empName));
		
		System.out.println("******************************");
		System.out.println("========Number of employees with age 20======");
		Long empCount = empArrayList.stream()
				.filter(emp -> emp.getAge() == 20)
				.count();
		System.out.println("Number of Employees with age 20: "+empCount);

		System.out.println("******************************");
		System.out.println("=========Find the employees with name ravi-rana========");
		Optional<Employee> e1 = empArrayList.stream()
				.filter(emp -> emp.getName().equalsIgnoreCase("ravi-rana"))
				.findAny();

		if(e1.isPresent())
			System.out.println(e1.get());

		System.out.println("******************************");
		System.out.println("========Find the maximum age of the employee========");
		OptionalInt max = empArrayList.stream()
				.mapToInt(Employee::getAge)
				.max();

		if(max.isPresent())
			System.out.println("maximum age for the employee is: "+max.getAsInt());
		
		System.out.println("******************************");
		System.out.println("=========Group by employee Name=========");

		Map<String, List<Employee>> map = empArrayList.stream()
				.collect(Collectors.groupingBy(Employee :: getName));
		
		map.forEach((empName, employeeListTemp) -> System.out.println("Name "+empName+"====>"+employeeListTemp));
		
		System.out.println("******************************");
		System.out.println("=========Group by employee department=========");
		
		Map<String, List<Employee>> employeeByDept= empArrayList.stream()
				.collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.toList()));

		//employeeByDept.forEach((dept, employeeList) -> System.out.println("Dept "+dept+"=====>"+employeeList));
		
		employeeByDept.entrySet().forEach(entry -> System.out.println(entry.getKey()+"----------"+entry.getValue()));
		
		System.out.println("******************************");
		System.out.println("=========employee count working in each department=========");
		
		Map<String, Long> empCntPerDept = empArrayList.stream()
				.collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.counting()));
		
		empCntPerDept.entrySet().forEach(entry -> System.out.println(entry.getKey()+"----------"+entry.getValue()));
		
		System.out.println("******************************");
		System.out.println("=========group by department=========");
		
		Map<String, List<Employee>> groupDept = empArrayList.stream().collect(Collectors.groupingBy(Employee :: getDepartment));
		groupDept.forEach((key, value) -> System.out.println(key+"--------"+value));
		
		System.out.println("******************************");
		System.out.println("=========sort by id=========");
		List<Employee> empSortId = empArrayList.stream().sorted(Comparator.comparingInt(Employee :: getId).reversed()).collect(Collectors.toList());
		empSortId.forEach(System.out :: println);
		
		System.out.println("******************************");
		System.out.println("=========sort by name=========");
		List<Employee> empSortName = empArrayList.stream()
				.sorted(Comparator.comparing(Employee :: getName)).collect(Collectors.toList());
		empSortName.forEach(System.out :: println);
		
		System.out.println("******************************");
		System.out.println("=========sort by Dept and name=========");
		
		Comparator<Employee> compareByNameDept = Comparator.comparing(Employee :: getDepartment).thenComparing(Employee :: getName);
		List<Employee> empSortIdName = empArrayList.stream().sorted(compareByNameDept).collect(Collectors.toList());
		empSortIdName.forEach(System.out :: println);
		
		System.out.println("******************************");
		System.out.println("=========Max and Min Salary of Employees=========");
		
		Optional<Employee> maxSalEmp = empArrayList.stream().max(Comparator.comparing(Employee :: getSalary));
		Optional<Employee> minSalEmp = empArrayList.stream().min(Comparator.comparing(Employee :: getSalary));
		
		System.out.println("Max salary "+maxSalEmp);
		System.out.println("Min salary "+minSalEmp);
		
		System.out.println("******************************");
		System.out.println("=========Max Salary of Employees from each department=========");
		
		Map <String, Optional<Employee>> maxSalEmpDeptWise = empArrayList.stream()
				.collect(Collectors.groupingBy(Employee :: getDepartment, 
				Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee :: getSalary)))));
		
		maxSalEmpDeptWise.entrySet().forEach(entry -> System.out.println(entry.getKey()+"---------"+entry.getValue()));
		
		System.out.println("******************************");
		System.out.println("=========Min Salary of Employees from each department=========");
		
		Map <String, Optional<Employee>> minSalEmpDeptWise = empArrayList.stream()
			.collect(Collectors.groupingBy(Employee :: getDepartment,
			Collectors.reducing(BinaryOperator.minBy(Comparator.comparing(Employee :: getSalary)))));
		
		minSalEmpDeptWise.forEach((key, value) -> System.out.println(key+"-------"+value));
		
		System.out.println("******************************");
		System.out.println("=========Join Employee Names with , =========");

		List<String> employeeNames = empArrayList.stream()
				.map(Employee::getName)
				.collect(Collectors.toList());
		
		String empoyeeNameStr = String.join(",", employeeNames);
		System.out.println("Employees are: "+empoyeeNameStr);
		
	}
}
