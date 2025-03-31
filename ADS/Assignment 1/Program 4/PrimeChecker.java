import java.util.Scanner;

public class PrimeChecker {
    public static boolean isPrime(int num, int divisor) {
        if (num < 2) { // Edge case: Numbers less than 2 are not prime
            return false;
        }
        if (divisor == 1) { // Base case: If we reached 1, it's prime
            return true;
        }
        if (num % divisor == 0) { // If divisible, it's not prime
            return false;
        }
        return isPrime(num, divisor - 1); // Recursively check with smaller divisor
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        boolean result = isPrime(num, num - 1);

        // Displaying the result
        System.out.println(num + (result ? " is a prime number." : " is not a prime number."));

        sc.close();
    }
}
