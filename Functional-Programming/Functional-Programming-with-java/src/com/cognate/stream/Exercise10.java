package com.cognate.stream;

import java.util.List;
import java.util.stream.Collectors;

//Create a List with length of all course title
public class Exercise10 {
	public static void main(String[] args) {
		List<String> courseList = List.of("Spring","Spring Boot", "API", "Microservice", "GCP", "AWS", "Docker", "K8s");
		List<Integer> lenthOfCourses= lengthOfAllCourses(courseList);
		System.out.println("lenthOfCourses=="+ lenthOfCourses);
		
	}

	private static List<Integer> lengthOfAllCourses(List<String> courseList) {
		return courseList.stream().map(course -> course.length()).collect(Collectors.toList());
	}

}
