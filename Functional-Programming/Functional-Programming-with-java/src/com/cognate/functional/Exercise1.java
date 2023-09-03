package com.cognate.functional;

import java.util.List;

public class Exercise1 {
    //Print only oadd numbers from list

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,22,15,33,55);
        printOddNumberInListFunctional(numbers);
    }

    private static void printOddNumberInListFunctional(List<Integer> numbers) {
        System.out.println("=======ODD NUMBERS WITH LAMBDA=========");
        numbers.stream()
                .filter(number -> number%2 != 0)
                .forEach(System.out::println);
    }
}
