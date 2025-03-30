import java.util.Scanner;

public class LongestWord {
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+"); // Split sentence into words
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for a sentence
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Finding the longest word
        String longestWord = findLongestWord(sentence);

        // Displaying the result
        System.out.println("Longest word: " + longestWord);

        sc.close();
    }
}
