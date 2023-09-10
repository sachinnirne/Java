package com.cognate.parallel;

import java.util.stream.LongStream;

public class Parallelizing {
	
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		
		//0, 100000000 : create and sum
		//System.out.println(LongStream.range(0, 100000000).sum());
		//System.out.println(System.currentTimeMillis()-time);
		
		//parallel
		System.out.println(LongStream.range(0, 100000000).parallel().sum());
		System.out.println(System.currentTimeMillis()-time);
	}

}
