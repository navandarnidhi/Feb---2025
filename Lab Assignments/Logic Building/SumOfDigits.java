/*
import java.util.Scanner;
public class SumOfDigits{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		
		int sum = 0;
		
		while(num > 0){
			//int digit = num % 10;
			//sum = sum + digit;
			
			sum = sum + num % 10;
			num = num / 10;
		}
		System.out.println("Sum: " + sum);
	
	}
}
*/

import java.util.Scanner;
public class SumOfDigits{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt(); //input : 1307
		
		
		while(num >= 10){
			
			// inner while loop sum is added here in the sum variable
			int sum = 0; // output of 1307 is 11

			// checking for sum
			while(num > 0){
				sum = sum + num % 10;
			    num = num / 10;
			} 
			num = sum;
		}
		System.out.println("Sum: " + num);
	
	}
}