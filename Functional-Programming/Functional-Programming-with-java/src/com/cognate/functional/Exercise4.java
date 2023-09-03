package com.cognate.functional;

import java.util.List;

public class Exercise4 {
    //print the cube of odd numbers
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,22,15,33,55);
        printCubeOfOddNumberInListFunctional(numbers);
    }

    private static void printCubeOfOddNumberInListFunctional(List<Integer> numbers) {
        System.out.println("=======Cube of ODD NUMBERS WITH LAMBDA=========");
        numbers.stream()
                .filter(number -> number%2 != 0)
                .map(number -> number * number * number)
                .forEach(System.out::println);
    }
}
