package com.cognate.structured;

import java.util.List;

public class Structured02 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,22,15,33,55);
        int sum = addListStructured(numbers);
        System.out.println(sum);
    }

    private static int addListStructured(List<Integer> numbers) {
        int sum = 0;
        for(int num: numbers){
            sum += num;
        }
        return  sum;
    }

}
