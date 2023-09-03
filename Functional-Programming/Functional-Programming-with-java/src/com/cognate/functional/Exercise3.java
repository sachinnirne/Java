package com.cognate.functional;

import java.util.List;

public class Exercise3 {
//print courses whose name atleast 4

    public static void main(String[] args) {
        List<String> courseList = List.of("Spring","Spring Boot", "API", "Microservice", "GCP", "AWS", "Docker", "K8s");
        printAllCoursesIndividually(courseList);
    }

    private static void printAllCoursesIndividually(List<String> courseList) {
        System.out.println("======print courses whose name atleast 4======");
        courseList.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

}
