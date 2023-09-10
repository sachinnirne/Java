package com.cognate.stream;

import java.util.Comparator;
import java.util.List;

public class DistinctAndSortedExample {

	public static void main(String[] args) {
		 List<Integer> numbers = List.of(12,9,13,4,6,2,4,22,15,33,55);
	    	distinctExample(numbers);
	    	sortedExample(numbers);
	    	distinctSorted(numbers);
	    	
	    List<String> courseList = List.of("Spring","Spring Boot", "API", "Microservice", "GCP", "AWS", "Docker", "K8s");
	    sortInNaturalOrder(courseList);
	    sortInReverseOrder(courseList);
	    sortInOrderOfStringLength(courseList);
	}



	private static void sortedExample(List<Integer> numbers) {
		System.out.println("==========DISTINCT==========");
		 numbers.stream().distinct().forEach(System.out::println);
	}

	private static void distinctExample(List<Integer> numbers) {
		System.out.println("==========SORTED==========");
		 numbers.stream().sorted().forEach(System.out::println);
	}
	
	private static void distinctSorted(List<Integer> numbers) {
		System.out.println("==========DISTINCT--SORTED==========");
		 numbers.stream().distinct().sorted().forEach(System.out::println);
		
	}
	
	private static void sortInNaturalOrder(List<String> courseList) {
		System.out.println("==========NATURAL SORTED==========");
		courseList.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		
	}
	private static void sortInReverseOrder(List<String> courseList) {
		System.out.println("==========NATURAL SORTED==========");
		courseList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
	}
	
	private static void sortInOrderOfStringLength(List<String> courseList) {
		System.out.println("==========SORTED: String Length Order==========");
		courseList.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
		
	}
}
