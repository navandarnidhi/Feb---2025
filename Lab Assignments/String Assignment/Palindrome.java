import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        boolean isPalindrome = true;
        int n = input.length();
        for (int i = 0; i < n / 2; i++) {
            if (input.charAt(i) != input.charAt(n - i - 1)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Is palindrome: " + isPalindrome);
    }
}


/* 
import java.util.Scanner;

public class Palindrome{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("Is palindrome: " + input.equals(reversed));
    }
}

*/