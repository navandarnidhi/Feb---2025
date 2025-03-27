import java.util.*;
public class FactorialRecu{
	static int factorial(int n){
		if (n <= 1){
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		
		int result = factorial(num);
		
		System.out.println("factorial of " + num + " is " + result);
		sc.close();
	}
}