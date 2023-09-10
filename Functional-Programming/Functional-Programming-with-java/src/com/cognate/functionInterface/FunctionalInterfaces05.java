package com.cognate.functionInterface;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaces05 {
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 22, 15, 33, 55);
		
		Predicate<Integer> isEvenPredicate = num -> num%2 ==0;
		
		Function<Integer, Integer> squareFunction = num -> num*num;
		
		Consumer<Integer> sysoutConsumer = num -> System.out.println(num);
		
		BinaryOperator<Integer> sumBinaryOperator = (num1, num2)-> num1 + num2;
		
		//supplier : no input and return something
		//Supplier<Integer> randomIntegerSupplier = () -> 2;
		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		System.out.println(randomIntegerSupplier.get());
		
		//unary operator : takes one parameter as input and return same type
		UnaryOperator<Integer> unaryOperator = (num) -> 3 * num;
		System.out.println(unaryOperator.apply(10));
		
		//BiPredicate: simpler to predicate : two inputs and return boolean back
		BiPredicate<Integer, String> biPredicate = (num, str) -> {
			return num<10 && str.length()>5;
		};
		System.out.println(biPredicate.test(15, "test"));
		
		//BiFunction
		BiFunction<Integer, String, String> biFunctiong = (num, str) -> {
			return num + " "+ str;
		};
		System.out.println(biFunctiong.apply(15, "test"));
		
		//BiConsumer
		BiConsumer<String, String>biConsumer = (str1, str2)->{
			System.out.println(str1);
			System.out.println(str2);
		};
		biConsumer.accept("test1", "test2");
	}

}
