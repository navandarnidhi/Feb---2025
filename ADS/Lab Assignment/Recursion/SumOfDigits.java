import java.util.Scanner;

public class SumOfDigits {

    public static int sum(int num) {
        if (num > 0 && num < 10) { 
            return num;
        } else {
			return (num % 10) + sum(num / 10);
		}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        // Calculate and display sum of digits
        int result = sum(n);
        System.out.println("Sum of digits: " + result);
        
        sc.close();
    }
}
