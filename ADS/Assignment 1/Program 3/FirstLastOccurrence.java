import java.util.Scanner;

public class FirstLastOccurrence {
    public static int[] findOccurrences(int[] arr, int key) {
        int firstIndex = -1, lastIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                if (firstIndex == -1) {
                    firstIndex = i;
                }
                lastIndex = i;
            }
        }
        return new int[]{firstIndex, lastIndex};
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

        // Take input for the key to search
        System.out.print("Enter the key to find occurrences: ");
        int key = scanner.nextInt();

        int[] result = findOccurrences(arr, key);

        // Print the result
        if (result[0] != -1) {
            System.out.println("First occurrence: " + result[0]);
            System.out.println("Last occurrence: " + result[1]);
        } else {
            System.out.println("Element not found.");
        }

        scanner.close();
    }
}
