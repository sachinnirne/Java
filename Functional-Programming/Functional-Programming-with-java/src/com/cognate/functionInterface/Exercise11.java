package com.cognate.functionInterface;

import java.util.List;
import java.util.function.BinaryOperator;

public class Exercise11 {
	//Functional Interfaces: Binary operator
	//Find functional interface behind the second argument of reduce method.
	//Create an implementation for the functional interface
	//int sum = numbers.stream().reduce(0, Integer::sum);  //Integer::sum : which functional interface



	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 22, 15, 33, 55);
		
		//BinaryOperator: this is also functional interface
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		
		//OR
		
		//detail Binary Operator
		BinaryOperator<Integer> sumBinaryOperatorDetails = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer num1, Integer num2) {
				return num1 + num2;
			}
		};
		
		numbers.stream().reduce(0, sumBinaryOperator);
	}
}
