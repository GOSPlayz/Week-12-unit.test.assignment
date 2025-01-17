package com.promineotech;

import java.util.Random;

public class TestDemo {
	public int addPositive (int a, int b) {
		if(a > 0 && b > 0) {
			return a + b;
		}
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
	public int randomNumberSquared() {
		int n = getRandomInt();
		
		return n * n;
	}
	
	int getRandomInt() {
	    Random random = new Random();
	    return random.nextInt(10) + 1;
	}
	
	// my work for section 3
	public int multiplyPositive (int a, int b) {
		if (a > 0 && b > 0) {
			return a * b;
		}
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
}