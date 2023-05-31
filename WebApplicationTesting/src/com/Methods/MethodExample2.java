package com.Methods;

public class MethodExample2 {
	
	public void addition()
	{
		int var1=10;
		int var2=20;
		int var3;
		
		var3=var1+var2;
		System.out.println("The addition of two numbers var1 and var2 is :- "+var3);
	}

	private void subtraction()
	{
		int var1=50;
		int var2=20;
		int var3;
		
		var3=var1-var2;
		System.out.println("The subtraction of two numbers var1 and var2 is :- "+var3);
	}
	
	protected void multiplication()
	{
		int var1=25;
		int var2=2;
		int var3;
		
		var3=var1*var2;
		System.out.println("The multiplication of two numbers var1 and var2 is :- "+var3);
	}
	
	void division()
	{
		int var1=10;
		int var2=2;
		int var3;
		
		var3=var1/var2;
		System.out.println("The division of two numbers var1 and var2 is :- "+var3);
	}
	
	public static void main(String[] args) {
		MethodExample2 obj= new MethodExample2();
		obj.addition();
		obj.subtraction();
		obj.multiplication();
		obj.division();
	}	
}

