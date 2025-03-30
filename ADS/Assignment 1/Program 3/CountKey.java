import java.util.Scanner;

public class CountKey {
    // Function to find the first occurrence of key
    public static int findFirstOccurrence(int[] arr, int key) {
        int left = 0, right = arr.length - 1, firstIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                firstIndex = mid;  // Potential first occurrence
                right = mid - 1;  // Move left to find earlier occurrences
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstIndex;
    }

    // Function to find the last occurrence of key
    public static int findLastOccurrence(int[] arr, int key) {
        int left = 0, right = arr.length - 1, lastIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                lastIndex = mid;  // Potential last occurrence
                left = mid + 1;  // Move right to find later occurrences
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastIndex;
    }

    public static int[] findOccurrences(int[] arr, int key) {
        int firstIndex = findFirstOccurrence(arr, key);
        int lastIndex = findLastOccurrence(arr, key);
        int count = (firstIndex == -1) ? 0 : (lastIndex - firstIndex + 1);
        return new int[]{firstIndex, lastIndex, count};
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Take input for array size
        System.out.print("Enter the number of elements in the sorted array: ");
        int n = scanner.nextInt();

        int arr[] = new int[n];

        // Take input for array elements (must be sorted)
        System.out.println("Enter " + n + " sorted elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Take input for the key to search
        System.out.print("Enter the key to find occurrences: ");
        int key = scanner.nextInt();

        int[] result = findOccurrences(arr, key);
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
        System.out.println("Total Count: " + result[2]);

        scanner.close();
    }
}
