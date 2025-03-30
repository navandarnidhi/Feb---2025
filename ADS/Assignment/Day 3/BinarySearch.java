/*
//Iterative Approach 
TC = O(log n)
SC = O(1)

public class BinarySearchIterative {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;  // Target found
            if (arr[mid] < target) left = mid + 1;  // Search right half
            else right = mid - 1;  // Search left half
        }
        return -1;  // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 10, 15, 18};
        int target = 10;
        int index = binarySearch(arr, target);
        System.out.println(index != -1 ? "Element found at index: " + index : "Element not found");
    }
}

*/

//Recursive Approach
//TC = O(log n)
//SC = O(log n) (due to recursive stack calls)

public class BinarySearch {
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;  // Base case
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) return binarySearch(arr, mid + 1, right, target);
        return binarySearch(arr, left, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 5;
        int index = binarySearch(arr, 0, arr.length - 1, target);
        System.out.println(index != -1 ? "Element found at index: " + index : "Element not found");
    }
}



