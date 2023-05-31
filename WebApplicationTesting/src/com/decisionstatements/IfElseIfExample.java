package com.decisionstatements;

public class IfElseIfExample {
	public static void main(String[] args) {
		int var1=110;
		int var2=100;
		int var3=80;
		if(var1>var2 && var1>var3) {
			System.out.println("var1 variable value is greater than var2 and var3 variable values");
		}
		else 
			if(var2>var3) {
				System.out.println("var2 variable value is greater than var1 and var3 variable values");
	     }	
		else {
				System.out.println("var3 valuable value is greater than var1 and var2 variable values");
			}
	   
  }
}