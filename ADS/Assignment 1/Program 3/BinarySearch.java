import java.util.*;

public class BinarySearch {
    public static int binarySearch(LinkedList<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = list.get(mid);  // O(n) operation for getting an element
            if (midValue == target) return mid;
            if (midValue < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        // Taking input for the list
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        System.out.println("Enter " + n + " sorted elements: ");
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        // Taking input for the target element
        System.out.print("Enter the target element: ");
        int target = scanner.nextInt();

        int index = binarySearch(list, target);
        System.out.println(index != -1 ? "Element found at index: " + index : "Element not found");

        scanner.close();
    }
}
