package com.LoopStatements;

public class ForLoop {
	public static void main(String[] args) {
		for(int i=1;i<4;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=7;i>=2;)
		{
			for(int j=i;j>=2;j=j-2)
			{
				System.out.print(i--);
			}
			System.out.println();
		}
	}
}
