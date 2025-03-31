import java.util.Scanner;

public class SumDigit {
    public static int sum(int num) {
        if (num == 0) return 0; // Base case
        return (num % 10) + sum(num / 10); // Recursive case
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int result = sum(num);

        // Displaying the result
        System.out.println("Sum of digits: " + result);

        sc.close();
    }
}
