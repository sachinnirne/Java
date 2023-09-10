package com.cognate.stream;

import java.util.List;
import java.util.stream.Collectors;

public class CollecttingStreamExample {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,22,15,33,55);
		
		//Square each one of them 
		List<Integer> squareNumber = squareNumberList(numbers);
		System.out.println("doubleNumbers: "+ squareNumber);
	}

	private static List<Integer> squareNumberList(List<Integer> numbers) {
		return numbers.stream().map(num -> num*num).collect(Collectors.toList());
	}

}
