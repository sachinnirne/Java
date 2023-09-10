package com.cognate.stream;

import java.util.List;

//Find sum of odd numbers in a list
public class Exercise8 {
    public static void main(String[] args) {
    	 List<Integer> numbers = List.of(12,9,13,4,6,2,4,22,15,33,55);
    	
    	System.out.println(findSumOfOddNumbers(numbers));

    }

	
	
	private static Integer findSumOfOddNumbers(List<Integer> numbers) {
		return numbers.stream().filter(num -> num%2==1)
								.reduce(0, Integer::sum);
		
	}
}
