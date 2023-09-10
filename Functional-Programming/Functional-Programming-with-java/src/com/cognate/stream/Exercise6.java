package com.cognate.stream;

import java.util.List;

//Square every number in a list and find the sum of squares
public class Exercise6 {
    public static void main(String[] args) {
    	 List<Integer> numbers = List.of(12,9,13,4,6,2,4,22,15,33,55);
    	System.out.println(squarEveryNumberAndFindSum(numbers));

    }

	private static Integer squarEveryNumberAndFindSum(List<Integer> numbers) {
		return numbers.stream().map(num -> num*num)
						.reduce(0, Integer::sum);
		
	}
	
}
