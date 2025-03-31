import java.util.Scanner;

public class PalindromeRecursive {
    public static boolean isPalindrome(String str, int left, int right) {
        if (left >= right) {
            return true; // Base case: If pointers have met or crossed, it's a palindrome
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false; // If characters at left and right don't match, it's not a palindrome
        }
        return isPalindrome(str, left + 1, right - 1); // Recursively check inner substring
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String string = sc.nextLine();

        // Checking if the input string is a palindrome
        boolean result = isPalindrome(string, 0, string.length() - 1);

        // Displaying the result
        System.out.println("Is \"" + string + "\" a palindrome? " + result);

        sc.close();
    }
}
