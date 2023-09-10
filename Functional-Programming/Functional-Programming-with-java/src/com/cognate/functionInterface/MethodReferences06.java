package com.cognate.functionInterface;

import java.util.List;
import java.util.function.Supplier;

public class MethodReferences06 {
	
	public static void main(String[] args) {
		List<String> courseList = List.of("Spring","Spring Boot", "API", "Microservice", "GCP", "AWS", "Docker", "K8s");
		
		courseList.stream()
		.map(str -> str.toUpperCase())
		.forEach(str -> System.out.println(str));
		
		
		//rewrite above with method reference
		courseList.stream()
		.map(str -> str.toUpperCase())
		.forEach(System.out::println);
		
		//OR with static method called
		
		courseList.stream()
		.map(str -> str.toUpperCase())
		.forEach(MethodReferences06::print); // method reference static method
		
		
		//OR with Object method
		courseList.stream()
		.map(String :: toUpperCase) // method reference with object method
		.forEach(MethodReferences06::print); // method reference static method
		
		
		//constructor method  reference
		Supplier<String> supplier = () -> new String ();
		
		//OR
		
		Supplier<String> supplier1 = String::new; // method reference for constructor 
		
		
		
	}
	
	
	private static void print(String str) {
		System.out.println(str);
	}
}
