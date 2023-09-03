package com.cognate.functional;

import java.util.List;

public class Exercise2 {
//print all courses individually

    public static void main(String[] args) {
        List<String> courseList = List.of("Spring","Spring Boot", "API", "Microservice", "GCP", "AWS", "Docker", "K8s");
        printAllCoursesIndividually(courseList);
    }

    private static void printAllCoursesIndividually(List<String> courseList) {
        System.out.println("======print all courses individually=======");
        courseList.stream()
                .forEach(System.out::println);
    }

}
