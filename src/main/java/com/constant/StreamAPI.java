package com.constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StreamAPI {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);

		// int checkNums = numbers.stream().reduce(0, Integer::sum);
		// int checkNums = numbers.stream().mapToInt(num -> num).sum();
		// int checkNums = numbers.stream().mapToInt(num -> num).findFirst().orElse(0);
		// int checkNums = numbers.stream().mapToInt(num -> num).peek().sum();

		// System.out.println(checkNums);

		// int nums[] = numbers.stream().mapToint(e -> e);

		com.model.Student student1 = new com.model.Student(1, "John", 56);
		com.model.Student student2 = new com.model.Student(2, "Rick", 78);
		com.model.Student student3 = new com.model.Student(3, "Smith", 34);
		com.model.Student student4 = new com.model.Student(4, "Rohny", 98);

		List<com.model.Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);

		System.out.println(students.stream().map(m -> m.getId()).collect(Collectors.toList()));

	}

}
