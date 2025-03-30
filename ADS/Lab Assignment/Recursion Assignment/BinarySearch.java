import java.util.Scanner;
class BinarySearch {
    static int bsearch(int arr[], int x, int l, int h) {
        if (h >= l) {
            int mid = l + (h - l) / 2; 
            if (arr[mid] == x)  
                return mid;
            if (arr[mid] > x)  
                return bsearch(arr, x, l, mid - 1);
            return bsearch(arr, x, mid + 1, h);  
        }
        return -1;  
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter " + n + " sorted elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();
        sc.close();
        int result = bsearch(arr, key, 0, n - 1);
        if (result == -1)
            System.out.println("Element not found!");
        else
            System.out.println("Element found at index: " + result);
    }
}
