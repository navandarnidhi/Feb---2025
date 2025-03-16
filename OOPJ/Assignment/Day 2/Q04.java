import java.util.Scanner;
public class Q04{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double avg;
		System.out.print("Enter first number: ");
		int a = sc.nextInt();
		System.out.print("Enter second number: ");
		int b = sc.nextInt();
		System.out.print("Enter third number: ");
		int c = sc.nextInt();
		avg = ((double)a + (double)b + (double)c)/3;
		System.out.printf("Average of 3: %.2f",avg);
	}
}