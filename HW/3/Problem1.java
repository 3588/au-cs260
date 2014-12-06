package hw3;

import java.util.Random;
import java.util.Scanner;

public class Problem1 {
	public static void prt(String str)
	{System.out.print(str);}
	public static void main(String[] args) {
		prt("Test searchMethod");
		prt("Enter 5 integer number:\n");
		Scanner intput = new Scanner(System.in);
		int[] intArray = new int[5];
		for(int i = 0; i<intArray.length;i++)
			intArray[i] = intput.nextInt();
		prt("Enter integer you looking for:\n");
		int intNumber=intput.nextInt();
		if (searchMethod(intArray, intNumber)) 
			prt("Find it in the array\n");
			else 
				prt("Can't find it in the array\n");
		
		prt("Test randomGeneratorMethod\nPlease Enter the size for array : ");
		intNumber=intput.nextInt();
		intArray = new int[intNumber];
		intArray=randomGeneratorMethod(intNumber);
		prt("The number between 1-260 in array is\n");
		for(int i = 0; i<intArray.length;i++)
			System.out.print(intArray[i]+" ");
		
		
	}
	public static boolean searchMethod(int[] intArray, int intNumber) {
		for(int i = 0; i<intArray.length;i++)
			if(intArray[i]==intNumber)
				return true;
		return false;
	}
	public static int[] randomGeneratorMethod(int size) {
		int[] intArray = new int[size];
		Random r=new Random();
		for(int i = 0; i<intArray.length;i++)
			intArray[i]=r.nextInt(259)+1;
		return intArray;
		
	}
}
