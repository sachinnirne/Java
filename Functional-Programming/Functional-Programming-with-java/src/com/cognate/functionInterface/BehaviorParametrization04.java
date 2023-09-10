package com.cognate.functionInterface;

import java.util.List;
import java.util.function.Predicate;

public class BehaviorParametrization04 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 22, 15, 33, 55);
		
		//Lets consider you want even number or odd numbers from the list
		
		//even number 
		System.out.println("Even number");
		numbers.stream()
		.filter(num -> num%2==0)
		.forEach(System.out::println);
		
		System.out.println("Odd number");
		//even number
		numbers.stream()
		.filter(num -> num%2!=0)
		.forEach(System.out::println);
		
		
		//================
		
		/*System.out.println("Even number");
		Predicate<? super Integer> evenPredicate = num -> num%2==0;
		
		numbers.stream()
		.filter(evenPredicate)
		.forEach(System.out::println);
		
		System.out.println("Odd number");
		//even number
		Predicate<? super Integer> oddPredicate = num -> num%2!=0; // create this method select filter logic right click -> reactor -> Extract local variable
		
		numbers.stream()
		.filter(oddPredicate)
		.forEach(System.out::println); */
		
		//If you see above code only behavior is different (filter method behavior) 
		
		// Now we can combine above code into single method and pass that method behavior(logic) as arg
				
		//even number 
		//System.out.println("Even number");
		//Predicate<? super Integer> evenPredicate = num -> num%2==0; //in line this select evenPredicate-> right click-> refactor-> inline
		
		//even number 
		System.out.println("Even number");
		filterAndPrint(numbers,  num -> num%2==0);
		
		System.out.println("Odd number");
		//even number
		filterAndPrint(numbers, num -> num%2!=0);
		
	
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}

}
