package com.cognate.functional;

import java.util.List;

public class Exercise5 {
    //print the number of characters in each courses
    public static void main(String[] args) {
        List<String> courseList = List.of("Spring","Spring Boot", "API", "Microservice", "GCP", "AWS", "Docker", "K8s");
        printNumberOfCharINEachCourses(courseList);
    }

    private static void printNumberOfCharINEachCourses(List<String> courseList) {
        System.out.println("======print the number of characters in each courses ======");
        courseList.stream()
                .map(course -> course + " : " +course.length())
                .forEach(System.out::println);
    }

}
