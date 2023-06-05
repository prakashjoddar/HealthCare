package com.constant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi2 {
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);
		nums.add(7);
		nums.add(8);
		nums.add(9);
		nums.add(10);

		List<Integer> evens = nums.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());

		System.out.println(evens);

//		List<Customer> customers = new ArrayList<>(); 

//		try {
//
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hb_student_tracker",
//					"user1", "user1");
//
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("select * from customer");
//			
//			while(rs.next()) {
//				
//			}
//
//		} catch (ClassNotFoundException ce) {
//			ce.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}
}
