package com.decisionstatements;

public class NestedIfExample {
	public static void main(String[] args) {
		int var1=30;
		int var2=20;
		int var3=10;
		if(var1>var2) {
			System.out.println("var1 variable value is greater than var2 variable value");
			if(var1>var3) {
				System.out.println("var1 variable value is greater than var3 variable value");
			}
		}
	}	
}


