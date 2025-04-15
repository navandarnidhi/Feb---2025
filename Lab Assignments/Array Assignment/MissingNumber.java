import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array (n-1): ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int total = (n + 1) * (n + 2) / 2;
        for (int num : arr) total -= num;

        System.out.println("Missing number is: " + total);
    }
}
