import java.util.HashMap;
import java.util.Scanner;

public class NonRepeatingElements {
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

        System.out.print("Non-repeating elements: ");
        for (int num : arr) {
            if (frequencyMap.get(num) == 1) {
                System.out.print(num + " ");
            }
        }

        scanner.close();
    }
}
