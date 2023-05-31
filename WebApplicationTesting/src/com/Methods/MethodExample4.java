package com.Methods;

public class MethodExample4 {
	
	public void addition()
	{
		//Local Variables
		int var1=10;
		int var2=20;
		int var3;
		
		var3=var1+var2;
		System.out.println("The addition of two numbers var1 and var2 is :- "+var3);
	}

	int var3;
	public void addition1()
	{
		int var1=10;
		int var2=20;
		
		var3=var1+var2;
		System.out.println("The addition of two numbers var1 and var2 is :- "+var3);
	}
	
	int var1=10; //Global Variables
	int var2=20; //Global Variables
	
	public void addition2()
	{
		var1=10;
		var2=20;
		
		var3=var1+var2;
		System.out.println("The addition of two numbers var1 and var2 is :- "+var3);
	}
	
	public void addition3()
	{
		
		var3=var1+var2;
		System.out.println("The addition of two numbers var1 and var2 is :- "+var3);
	}
	
	
	public void methodWithParametes(double var1,double var2)
	{
		double var3=var1+var2;
		System.out.println("The addition of two double numbers var1 and var2 is :- "+var3);
	}
	
	public void methodWithDifferentDataType(int var1,double var2)
	{
		double var3=var1+var2;
		System.out.println("The additin of two different dataTypes var1 and var2 is :- "+var3);
	}
	
	public void methodWithParametes(double var1,double var2,double var3)
	{
		double var4=var1+var2+var3;
		System.out.println("The addition of three double numbers var1 and var2 is :- "+var4);
	}
	
	
	public static void main(String[] args) {
		
		MethodExample4 m4=new MethodExample4();
		
		m4.addition();
		m4.addition1();
		m4.addition2();
		m4.addition3();
		m4.methodWithParametes(10.111,10.111);
		m4.methodWithDifferentDataType(10, 10.111);
		m4.methodWithParametes(10.111, 10.111, 10.111);

		
	}	
}
