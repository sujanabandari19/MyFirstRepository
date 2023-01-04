package com.hack2hire.appointments;

public class LambdaDemo {

	public static void main(String[] args) {
		FInterface intObj = new FClass();
		System.out.println("compute "+intObj.compute(5, 20));
		
		
		FInterface intObj2 = (int a, int b) -> {
			return a+b;
		};
		
		System.out.println("Compute of functional interface "+intObj2.compute(5, 20));

	}

}
