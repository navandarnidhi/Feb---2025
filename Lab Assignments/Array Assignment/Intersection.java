import java.util.*;

public class Intersection {
    
    public static void findIntersection(int arr1[], int arr2[]) {
        HashSet<Integer> intersection = new HashSet<>();
        
        for (int num : arr1) {
            intersection.add(num); // Add all elements from arr1 to set
        }
        
        System.out.print("Intersection of two arrays: ");
        for (int num : arr2) {
            if (intersection.contains(num)) {
                System.out.print(num + " ");
                intersection.remove(num); // Avoid duplicate prints
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // Input for first array
        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();
        int arr1[] = new int[n1];
        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        
        // Input for second array
        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();
        int arr2[] = new int[n2];
        System.out.println("Enter elements of second array:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        // Call method to find intersection
        findIntersection(arr1, arr2);
        
        sc.close();
    }
}
