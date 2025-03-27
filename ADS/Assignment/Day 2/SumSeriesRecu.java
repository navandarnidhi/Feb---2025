import java.util.*;

public class SumSeriesRecu{
	static int sumSeries(int n){
		if (n == 0){
			return 0;
		} else {
			return n + sumSeries(n - 1);
		}
	}
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Enter number to be sumed up: ");
		int num = sc.nextInt();
		
		int result = sumSeries(num);
	
		System.out.println("Sum of numbers from 1 to " + num + " is: " + result);
	
		sc.close();
	}

}