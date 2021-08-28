package com.interview.programs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
	private int id;
    private String name;
    private String department;
    private int salary;
    private int age;
}