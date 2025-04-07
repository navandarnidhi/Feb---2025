import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    public static void countSort(int[] arr) {
        int max_val = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max_val + 1];
        int[] output = new int[arr.length];

        // Count occurrences
        for (int num : arr) {
            count[num]++;
        }

        // Cumulative sum
        for (int i = 1; i <= max_val; i++) {
            count[i] += count[i - 1];
        }

        // Sorting step
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy sorted values back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        countSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));

        scanner.close();
    }
}
