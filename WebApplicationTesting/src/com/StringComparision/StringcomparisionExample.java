package com.StringComparision;

public class StringcomparisionExample {
	public static void main(String[] args) {
		String name="Vamshi";
		System.out.println(name);
		
		System.out.println(name.charAt(5));
		System.out.println(name.charAt(0));
		
		System.out.println(name.toUpperCase());
		
		String customer=name.toLowerCase();
		System.out.println(customer);
		
		
		
		String string1="Livetech";
		int stringlength=string1.length();
		System.out.println(stringlength);
		
		String string2="Lenovo";
		String string3="Lenovocom";
		if(string2.equals(string3))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
	
		
		if(string3.contains(string2))
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");
		}
		
		String string4="computers";
		String string5="COMputers";
		if(string4.equalsIgnoreCase(string5))
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");
		}
	
	}	

}
