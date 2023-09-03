package com.cognate.structured;

import java.util.List;

public class Structured01 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,22,15,33,55);
        printAllNumberInListStructured(numbers);
        printEvenNumberInListStructured(numbers);
    }

    //First Example
    private static void printAllNumberInListStructured(List<Integer> numbers) {
        for(int num: numbers){
            System.out.println("=========All Numbers========");
            System.out.println(num);
        }
    }

    //Second Example
    private static void printEvenNumberInListStructured(List<Integer> numbers){
        System.out.println("=========Even Numbers========");
        for(int num: numbers){
            if(num%2==0) {
                System.out.println(num);
            }
        }
    }
}
