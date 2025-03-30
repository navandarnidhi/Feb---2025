import java.util.*;

public class SecondLargest {
    public static int secondLargest(int array[]) {
        Arrays.sort(array); // Sorting in ascending order
        
        int n = array.length;
        int largest = array[n - 1]; // Largest element
        
        for (int i = n - 2; i >= 0; i--) { // Traverse from second last element
            if (array[i] < largest) {
                return array[i]; // First smaller unique number found
            }
        }
        return -1; // No second largest found
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = secondLargest(arr);
        if (result == -1) {
            System.out.println("No second largest element found.");
        } else {
            System.out.println("The second largest element is: " + result);
        }

        sc.close();
    }
}
