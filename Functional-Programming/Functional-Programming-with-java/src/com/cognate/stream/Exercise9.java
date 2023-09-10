package com.cognate.stream;

import java.util.List;
import java.util.stream.Collectors;

//Create a List with even numbers filtered from the number list
public class Exercise9 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,22,15,33,55);
		List<Integer> evenNumbers= evenNumberList(numbers);
		System.out.println("evenNumbers=="+ evenNumbers);
		
	}

	private static List<Integer> evenNumberList(List<Integer> numbers) {
		return numbers.stream().filter(num -> num%2 ==0).collect(Collectors.toList());
	}

}
