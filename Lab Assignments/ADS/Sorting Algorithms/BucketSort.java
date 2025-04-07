import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BucketSort {

    public static void bucketSort(float[] arr) {
        int n = arr.length;
        float max_val = Float.MIN_VALUE;
        for (float num : arr) {
            if (num > max_val) {
                max_val = num;
            }
        }

        // Create empty buckets
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Insert elements into their respective buckets
        for (int i = 0; i < n; i++) {
            int index = (int) (arr[i] * n / (max_val + 1));
            buckets[index].add(arr[i]);
        }

        // Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate all sorted buckets into the original array
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float num : buckets[i]) {
                arr[index++] = num;
            }
        }
    }

    public static void printArray(float[] arr) {
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        float[] arr = new float[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextFloat();
        }

        bucketSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);

        scanner.close();
    }
}
