package com.Methods;

public class MethodExample1 {
	
	public void addition()
	{
		int var1=10;
		int var2=20;
		int var3;
		
		var3=var1+var2;
		System.out.println("The addition of two numbers var1 and var2 is :- "+var3);
	}
	public static void main(String[] args) {
		MethodExample1 obj=new MethodExample1();
		obj.addition();
	}
	

}
