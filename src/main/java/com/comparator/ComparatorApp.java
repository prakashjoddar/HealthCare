package com.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.model.Student;

public class ComparatorApp {
	public static void main(String[] args) {
		Student s1 = new Student(1, "John", 45);
		Student s2 = new Student(2, "Rick", 89);
		Student s3 = new Student(3, "Max", 23);
		Student s4 = new Student(4, "Ken", 39);
		Student s5 = new Student(5, "Natilia", 92);

		ArrayList<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);

		System.out.println("Before Sort");
		System.out.println(students);

		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (int) (o1.getMarks() - o2.getMarks());
			}
		});

		System.out.println("After Sort");
		System.out.println(students);
	}
}
