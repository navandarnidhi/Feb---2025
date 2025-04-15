import java.util.*;

public class PairsWithSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Enter target sum:");
        int target = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        Set<String> seenPairs = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                int a = Math.min(num, complement);
                int b = Math.max(num, complement);
                seenPairs.add("(" + a + "," + b + ")");
            }
            set.add(num);
        }

        System.out.println("Pairs with sum " + target + ": " + seenPairs);
    }
}
