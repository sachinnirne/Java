package com.cognate.functional;

import java.util.List;

public class Functional01 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,22,15,33,55);
        printAllNumberInListFunctional(numbers);
        printEvenNumberInListFunctional(numbers);
        printSquaresOfEvenNumberInListFunctional(numbers);
    }

    //01-  FIRST EXAMPLE
//    private static void print(int num){
//        System.out.println(num);
//    }
//
//    private static void printAllNumberInListFunctional(List<Integer> numbers) {
//        //converting list to stream
//        //We have used Method Reference(::) to print numbers. (classname::methodName)
//        numbers.stream()
//                .forEach(Functional01::print); //Method Reference
//
//    }

    //02- Enhance
    private static void printAllNumberInListFunctional(List<Integer> numbers) {
        //converting list to stream
        System.out.println("===ALL NUMBER WITH METHOD REFERENCE====");
        numbers.stream()
                .forEach(System.out::println); //Method Reference

    }

    //03- Second Example
//    private static boolean isEven(int num){
//      return num % 2==0;
//    }
//    private static void printEvenNumberInListFunctional(List<Integer> numbers) {
//        numbers.stream()
//                .filter(Functional01::isEven) //filter only allowed even number
//                .forEach(System.out::print); //Method Reference
//    }

    //Without isEven we can directly add into filter (using lambda expression)
    private static void printEvenNumberInListFunctional(List<Integer> numbers) {
        System.out.println("===EVEN NUMBER WITH LAMBDA====");
        numbers.stream()
                .filter(number -> number%2 == 0) // Lambda Expression (Filter only allowed even number)
                .forEach(System.out::println); //Method Reference
    }

    //Third Example (map in functional Programming)
    private static void printSquaresOfEvenNumberInListFunctional(List<Integer> numbers) {
        System.out.println("===Squares Of EVEN NUMBER WITH LAMBDA====");
        numbers.stream()
                .filter(number -> number%2 == 0) // Lambda Expression (Filter only allowed even number)
                .map(number -> number * number)
                .forEach(System.out::println); //Method Reference
    }
}
