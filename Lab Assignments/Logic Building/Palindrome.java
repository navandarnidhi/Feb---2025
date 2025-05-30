/*
import java.util.Scanner;
public class Palindrome{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		int original = num;
		int reversed = 0;
		
		while(num > 0){
			int digit = num % 10;
			reversed = reversed * 10 + digit;
			num = num / 10;
		}
		
		if (original == reversed) {
			System.out.println("Palindrome!");
		}
		else {
			System.out.println("Not Palindrome!");
		}
	}
}
*/
import java.util.Scanner;
public class Palindrome{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		String str = sc.next();
		String reversed = new StringBuilder(str).reverse().toString();
		
		System.out.println(str.equals(reversed) ? "Palindrome":"Not Palindrome");
	}
}

/* 
121 % 10 = 1
reversed = 0 * 10 + 1 =1
num = 121 / 10 =12

num 12
12 % 10 =2
reversed 12
num 12/10 = 1

num 1
1 % 10 = 1
reversed = 121
num = 0
*/
