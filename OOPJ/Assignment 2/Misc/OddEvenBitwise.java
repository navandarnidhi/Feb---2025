import java.util.Scanner;

public class OddEvenBitwise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println((num & 1) == 0 ? "Even" : "Odd"); // Checks LSB using bitwise AND
        sc.close();
    }
}
