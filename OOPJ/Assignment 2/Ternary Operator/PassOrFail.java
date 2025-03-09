import java.util.Scanner;

public class PassOrFail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter percentage: ");
        int percentage = sc.nextInt();

        String result = (percentage >= 40) ? "Pass" : "Fail";

        System.out.println(result);
        sc.close();
    }
}
