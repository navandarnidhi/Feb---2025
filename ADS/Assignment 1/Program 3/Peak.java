import java.util.Scanner;

public class Peak {
    public static int findLargest(int[] array) {
        int largest = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        return largest;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Take input for array size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int arr[] = new int[n];

        // Take input for array elements
        System.out.println("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int largest = findLargest(arr);
        System.out.println("The largest element of given array: " + largest);

        scanner.close();
    }
}
