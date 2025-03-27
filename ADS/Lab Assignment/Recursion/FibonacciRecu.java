import java.util.*;

public class FibonacciRecu {
    static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of terms for Fibonacci series: ");
        int num = sc.nextInt();

        System.out.print("Fibonacci Series: ");
        for (int i = 0; i <= num; i++) {
            System.out.print(fib(i) + " ");
        }

        sc.close();
    }
}
