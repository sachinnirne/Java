package com.cognate.functionInterface;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces03 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 22, 15, 33, 55);
		
		//=============Predicate======================
		
		// Predicate in boolean-valued function of one argument
		Predicate<Integer> isEvenPredicate = num -> num%2==0; 
		
		//OR
		
		//What happens in background with this predicate
		Predicate<Integer> isEvenPredicateDetails =  new Predicate<Integer>() {
			@Override
			public boolean test(Integer num) {
				return num%2==0;
			}
		};
		
		//=============Function======================
		
		//Function that access one argument and produces a result
		Function<Integer, Integer> squarFunction = num -> num * num; 
		
		//OR
		
		//What happens in background with this Function
		Function<Integer, Integer> squarFunctionDetails = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer num) {
				return num*num;
			}
		};
		
		//=============Consumer======================
		//Consumer accept one input argument and return no result(void)
		Consumer<Integer> sysoutConsumer = System.out::println;
		
		//OR
		
		Consumer<Integer> sysoutConsumerDetails = new Consumer<Integer>() {
			@Override
			public void accept(Integer num) {
				
				System.out.println(num);
			}
		};
		
		numbers.stream()
				.filter(isEvenPredicate)
				.map(squarFunction)
				.forEach(sysoutConsumer);
	}
}
