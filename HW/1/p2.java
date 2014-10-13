//junjun huang assignment 1
package hw1;
public class p2
{
	//Problem 2
	//Write a program that declares the following:
	//1. a String variable named name
	//2. an int variable named age
	//3. a double variable named annualPay
	//Store your age, name, and desired annual income as literals in these variables. The program should display
	//these values on the screen in a manner similar to the following:
	//My name is Paul Cao, my age is 35 and I hope to earn $100.0 per year.
	public static void main(String [] args)
	{
		String name = "Junjun Huang";
		int age = 28;
		double annualPay = 99.99;
		System.out.print("My name is ");
		System.out.print(name);
		System.out.print(", my age is ");
		System.out.print(age);
		System.out.print(" and I hope to earn $");
		System.out.print(annualPay);
		System.out.print(" per year.");
	}
	}