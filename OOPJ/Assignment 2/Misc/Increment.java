import java.util.Scanner;

public class Increment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int incrementedNum = -(~num); // Equivalent to num + 1

        System.out.println("Incremented number: " + incrementedNum);
        sc.close();
    }
}
