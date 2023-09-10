package com.cognate.custom;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * allMatch(), noneMatch(), anyMatch()
 * 
 * sorting with comparator
 * 
 * limit(), skip(), takeWhile() and dropWhile()
 * 
 * 
 * max(), min(), findFirst() and findAny()
 * 
 * 
 * sum(), average() and count()
 * 
 * 
 * groupingBy()
 * 
 * 
 * @author sachinnirne
 *
 */
class Course {
	
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	
	
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	
	
	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}
	
}

public class CustomClass {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring", "Boot", 98, 20000),
				new Course("Spring", "Framework", 95, 18000),
				new Course("API", "Microservice", 97, 15000),
				new Course("Microservice", "Microservice", 98, 12000),
				new Course("AWS", "Cloud", 92, 13000),
				new Course("Azure", "Cloud", 90, 16000),
				new Course("Docker", "Cloud", 93, 19000),
				new Course("Kubernets", "Cloud", 94, 21000));
		
		
		//allMatch, noneMatch, anyMatch
		//allMatch -> return true If every element in the stream matches the condition 
		//noneMatch -> return true If no element in the stream matches the condition 
		//anyMatch -> return true If at least one element in the stream matches the condition 
		Predicate<Course> reviewScoreGreaterThan90Predicate = course ->course.getReviewScore()>90;
		
		Predicate<Course> reviewScoreGreaterThan95Predicate = course ->course.getReviewScore()>95;
		
		Predicate<Course> reviewScoreLessThan90Predicate = course ->course.getReviewScore()<90;
		
		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan90Predicate));
		System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan95Predicate));
		System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
		System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
		System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));
		
		//Sorting Primititives : use instead of comparing method==> use comparingInt method for Integer
		
		Comparator comapringByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);
		System.out.println(courses.stream().sorted(comapringByNoOfStudents).collect(Collectors.toList()));
		
		Comparator comapringByNoOfStudentsDecresing = Comparator.comparingInt(Course::getNoOfStudents).reversed();
		System.out.println(courses.stream().sorted(comapringByNoOfStudentsDecresing).collect(Collectors.toList()));
		
		Comparator comapringByNoOfStudentsAndNoOfReviews = Comparator.comparingInt(Course::getNoOfStudents)
				.thenComparingInt(Course::getReviewScore)
				.reversed();
				
		System.out.println(courses.stream().sorted(comapringByNoOfStudentsAndNoOfReviews).collect(Collectors.toList()));
		
		
		
		//=========================limit(), skip(), takeWhile() and dropWhile()=========================
		//Limit: top 5 courses
		System.out.println(courses.stream()
				.sorted(comapringByNoOfStudentsAndNoOfReviews)
				.limit(5)
				.collect(Collectors.toList()));
		
		// skip: skip 3 courses
		System.out.println(
				courses.stream().sorted(comapringByNoOfStudentsAndNoOfReviews).skip(3).collect(Collectors.toList()));
		
		// Limit: top 5 courses and Skip: skip 3 courses
		System.out.println(
				courses.stream().sorted(comapringByNoOfStudentsAndNoOfReviews).skip(3).limit(5).collect(Collectors.toList()));
		
		//takeWhile :  once condition is false break the execution (just like break) --once condition false then break the execution
		System.out.println(
				courses.stream().takeWhile(course -> course.getReviewScore()>=95).collect(Collectors.toList()));
		//dropWhile: once  condition true 
		System.out.println(
				courses.stream().dropWhile(course -> course.getReviewScore()>=95).collect(Collectors.toList()));
		
		
		//=========================min and max=========================
		System.out.println(
				courses.stream().max(comapringByNoOfStudentsAndNoOfReviews));
		
		System.out.println(
				courses.stream().min(comapringByNoOfStudentsAndNoOfReviews));
		

		System.out.println(
				courses.stream().min(comapringByNoOfStudentsAndNoOfReviews)
				.orElse(new Course("JavaScript","Scripting", 150000, 93)));
		
		
		System.out.println(
				courses.stream().filter(reviewScoreLessThan90Predicate)
				.min(comapringByNoOfStudentsAndNoOfReviews)
				.orElse(new Course("JavaScript","Scripting", 150000, 93)));
		
		
		
		//findFirst and findAny
		System.out.println(
				courses.stream().filter(reviewScoreLessThan90Predicate)
				.findFirst());
		
		System.out.println(
				courses.stream().filter(reviewScoreGreaterThan95Predicate)
				.findFirst());
		
		System.out.println(
				courses.stream().filter(reviewScoreGreaterThan95Predicate)
				.findAny());
		
		//=========================sum(), average() and count=========================
		
		//sum: total number of student who give review rating greater than 95
		
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.sum());
		
		// average: average number of student who give review rating greater than 95

		System.out.println(
				courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).average());

		// count: count number of student who give review rating greater than 95

		System.out.println(
				courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).count());

		// max: max number of student who give review rating greater than 95

		System.out.println(
				courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).max());
		
		// min: min number of student who give review rating greater than 95

		System.out.println(
				courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).min());
		
		
		//=========================grouping()=========================
		//course category group
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
		
		//grouping with count
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,
				Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		
		
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,
				Collectors.mapping(Course::getName, Collectors.toList()))));
		
		
		
		//=========================HIGHER ORDER FUNCTION=========================
		// Higher order function:  The function which return another function
		Predicate<Course> reviewScoreGreaterThan95Predicate2 = CreatePredicateWithCutOffReviewScore(95);
		
		
		//Performance operation on stream : 
		//All intermediate operation on stream are lazy.. only when terminal operation executed then intermediate operation executed in java
		System.out.println(courses.stream().filter(course -> course.getName().length()>11)
						.map(course -> course.getName().toUpperCase())
						.peek(System.out::println)
						.findFirst());
		
		System.out.println(courses.stream().filter(course -> course.getName().length()>11)
				.map(course -> course.getName().toUpperCase()).findFirst());
		
		
	}

	//This called higher order function: we are returning logic back(predicate)
	private static Predicate<Course> CreatePredicateWithCutOffReviewScore(int cutOffReviewsScore) {
		return course -> course.getReviewScore() > cutOffReviewsScore;
	}

}
