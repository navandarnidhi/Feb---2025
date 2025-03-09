import java.util.Scanner;

public class MinOfFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter four numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int min = (a < b) ? ((a < c) ? ((a < d) ? a : d) : (c < d ? c : d)) 
                          : ((b < c) ? ((b < d) ? b : d) : (c < d ? c : d));

        System.out.println("Minimum number: " + min);
        sc.close();
    }
}
