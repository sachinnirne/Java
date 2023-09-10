package com.cognate.functionInterface;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//Do behavior parameterization for the mapping logic
//List squareNumbers = numbers.stream().map(num -> num*num).cillect(Collectors.toList());
public class Exercise12 {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 22, 15, 33, 55);
		
		List<Integer> sqauredNumbers = mapAndCreateNewList(numbers, num -> num*num);
		
		List<Integer> cubedNumbers = mapAndCreateNewList(numbers, num -> num*num*num);
		
		List<Integer> doubleNumbers = mapAndCreateNewList(numbers, num -> num + num);
		
		System.out.println(sqauredNumbers);
		
		System.out.println(cubedNumbers);
		
		System.out.println(doubleNumbers);
	}

	private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<? super Integer, ? extends Integer> mapFunction) {
		return numbers.stream()
		.map(mapFunction)
		.collect(Collectors.toList());
	}
}
