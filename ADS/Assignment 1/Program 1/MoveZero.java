import java.util.*;

public class MoveZero {
    public static void findMovingZeroEnd(int arr[]) {
        int index = 0; // For non-zero elements

        // Move non-zero elements to the front
        for (int num : arr) {
            if (num != 0) {
                arr[index++] = num;
            }
        }

        // Fill remaining positions with zeros
        while (index < arr.length) {
            arr[index++] = 0;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        // Taking input for array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Moving zeros to the end
        findMovingZeroEnd(arr);

        // Printing the result
        System.out.println("Array after moving zeros to the end: " + Arrays.toString(arr));

        sc.close();
    }
}
