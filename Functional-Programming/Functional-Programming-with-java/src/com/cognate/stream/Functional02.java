package com.cognate.stream;

import java.util.List;

public class Functional02 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,22,15,33,55);
        int sum = addListStructured(numbers);
        System.out.println(sum);
    }

//    private static int sum(int a, int b){
//        return a + b;
//    }

    //reduce operation : take sequence of numbers and reduce to one result
//    private static int addListStructured(List<Integer> numbers) {
//        //stream of number -> One Result value
//        //combine them into one result => one value
//        //0 and (a,b ) -> a + b
//        // initial value is 0 (Like int sum =0)
//       return numbers.stream()
//                .reduce(0, Functional02::sum);
//    }

    //Enhancing above code
//        0 + 12
//        12 + 9
//        21 + 13
//        34 + 4
//        38 + 6
//        44 + 2
//        46 + 4
//        50 + 22
//        72 + 15
    private static  int sum(int aggregate, int nextNumber){
        System.out.println(aggregate + " + "+ nextNumber);  //What happence in background of reduce to check
        return  aggregate + nextNumber;
    }

    //Enhance Above code
    //reduce operation : Take sequence of numbers and reduce to one result
//    private static int addListStructured(List<Integer> numbers) {
//        //stream of number -> One Result value
//        //combine them into one result => one value
//        //0 and (a,b ) -> a + b
//        // initial value is 0 (Like int sum =0)
//        return numbers.stream()
//                //.reduce(0, Functional02::sum); // First value is identity and second is Accumulated Function
//                //.reduce(0, (x,y)-> x+y);
//                .reduce(0, Integer::sum);
//
//    }

    private static int addListStructured(List<Integer> numbers) {
        //stream of number -> One Result value
        //combine them into one result => one value
        //0 and (a,b ) -> a + b
        // initial value is 0 (Like int sum =0)
        return numbers.stream()
                //.reduce(0, (x,y) -> x>y ? x : y ); //max number (This only for +ve number because start value 0)
                //.reduce(Integer.MIN_VALUE, (x,y) -> x>y ? x : y); ///max number  with Integer min value
                .reduce(Integer.MAX_VALUE, (x,y) -> x>y ? y :x); //MIn Value
    }

}
