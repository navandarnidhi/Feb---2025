import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {

    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences of digits
        for (int i = 0; i < n; i++) {
            int index = (arr[i] / exp) % 10;
            count[index]++;
        }

        // Update count array to contain the position of digits
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i] / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        // Copy the output array to arr
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void radixSort(int[] arr) {
        int max_val = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; max_val / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
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

        radixSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));

        scanner.close();
    }
}
