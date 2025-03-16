import java.util.Scanner;

public class SumOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Taking input for array elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Calculating the sum of all elements
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // Displaying the sum
        System.out.println("Sum of all elements: " + sum);
        
        scanner.close();
    }
}
