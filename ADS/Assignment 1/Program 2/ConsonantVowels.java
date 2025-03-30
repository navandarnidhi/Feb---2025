import java.util.Scanner;

public class ConsonantVowels {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for a sentence
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine().toLowerCase();

        int vowelCount = 0;
        int consonantCount = 0;

        // Counting vowels and consonants
        for (char ch : sentence.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        // Displaying results
        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);

        sc.close();
    }
}
