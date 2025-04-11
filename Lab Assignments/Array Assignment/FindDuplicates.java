import java.util.Scanner;

public class FindDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Duplicate elements and their counts:");
        boolean hasDuplicates = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) continue; // Skip already processed elements

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    arr[j] = -1; // Mark as processed
                }
            }

            if (count > 1) {
                hasDuplicates = true;
                System.out.println(arr[i] + " appears " + count + " times");
            }
        }

        if (!hasDuplicates) {
            System.out.println("No duplicates found.");
        }

        scanner.close();
    }
}




// By sorting ALgorithm
/*
import java.util.Arrays;
import java.util.Scanner;

public class FindDuplicatesSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sort the array
        Arrays.sort(arr);

        System.out.println("Duplicate elements and their counts:");
        boolean hasDuplicates = false;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (count > 1) {
                    hasDuplicates = true;
                    System.out.println(arr[i - 1] + " appears " + count + " times");
                }
                count = 1; // Reset count for the new number
            }
        }

        // Check last element's count
        if (count > 1) {
            hasDuplicates = true;
            System.out.println(arr[n - 1] + " appears " + count + " times");
        }

        if (!hasDuplicates) {
            System.out.println("No duplicates found.");
        }

        scanner.close();
    }
}

*/


// By Hashmap
/*
import java.util.HashMap;
import java.util.Scanner;

public class FindDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count occurrences
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("Duplicate elements and their counts:");
        boolean hasDuplicates = false;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) > 1) {
                hasDuplicates = true;
                System.out.println(key + " appears " + frequencyMap.get(key) + " times");
            }
        }

        if (!hasDuplicates) {
            System.out.println("No duplicates found.");
        }

        scanner.close();
    }
}

*/