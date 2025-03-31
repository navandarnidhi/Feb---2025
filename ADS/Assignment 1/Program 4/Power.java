import java.util.Scanner;

public class Power {
    static int power(int base, int exponent) {
        if (exponent == 0) { // Base case: Any number raised to 0 is 1
            return 1;
        }
        return base * power(base, exponent - 1); // Recursive case
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for base and exponent
        System.out.print("Enter the base: ");
        int base = sc.nextInt();

        System.out.print("Enter the exponent: ");
        int exponent = sc.nextInt();

        // Calculating power using recursion
        int result = power(base, exponent);

        // Displaying the result
        System.out.println(base + "^" + exponent + " = " + result);

        sc.close();
    }
}
