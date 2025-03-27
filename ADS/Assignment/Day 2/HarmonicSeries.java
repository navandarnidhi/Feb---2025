import java.util.*;

public class HarmonicSeries{
	static double sumSeries(int n){
		if (n == 1) {
				return 1.0; // Base case
		}

		double term;
		if (n % 2 == 0) {
			term = -1.0 / n; // If n is even, subtract
		} else {
			term = 1.0 / n; // If n is odd, add
		}

		return term + sumSeries(n - 1); // Recursive call
		
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a the number of terms: ");
		int num = sc.nextInt();
		
		double result = sumSeries(num);
		
		System.out.println("Sum of the series up to " + num + " terms: " + result);
		
		sc.close();
	}
}

