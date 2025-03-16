import java.util.Scanner;

public class VowelOrConsonant {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = scn.next().toLowerCase().charAt(0);

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            System.out.println(ch + " is a vowel.");
        } else if (Character.isLetter(ch)) {
            System.out.println(ch + " is a consonant.");
        } else {
            System.out.println("Invalid input, please enter a letter.");
        }
    }
}
