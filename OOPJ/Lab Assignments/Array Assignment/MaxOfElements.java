import java.util.Scanner;

public class MaxOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking input for array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        // Taking input for array elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Finding maximum element
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        
        // Displaying the maximum element
        System.out.println("The maximum element in the array is: " + max);
        
        scanner.close();
    }
}
