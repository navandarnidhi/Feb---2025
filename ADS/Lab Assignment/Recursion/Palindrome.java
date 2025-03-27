import java.util.Scanner;
class Palindrome {
    static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        return false;
    }

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
        String str = sc.nextLine();  
        boolean result = isPalindrome(str);
        System.out.println("Is the string: " + str);
		System.out.println("String is palindrome: " + result);
    }
}