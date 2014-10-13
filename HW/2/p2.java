package hw2;

import java.util.Scanner;

public class p2 {
	public static void prt(String str)
	{System.out.print(str);}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//String sentence = input.next();
		String sentence ;
		sentence = "this is Paul Cao! Hello there from CS260!";
		for(int i = 32;i<127;i++)
		{
			int tempInt=0;
			tempInt=frequencies(sentence, (char)i);
			if(tempInt!=0)
			prt((char)i+": "+tempInt+"\n"); //display
		}
	}
	public static int frequencies(String s, char ch)
	{
		int total = 0;
		int nuString = s.length();
		for(int i = nuString-1;i>-1;i--)
		{
			if(s.charAt(i)==ch)
				total++;
		}
		return total;
		
	}

}
