import java.util.*;

public class Anagrams {
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        int freq[] = new int[26]; // Array to store character frequencies
        
        // Process both strings
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'a']++;  // Increase for str1
            freq[str2.charAt(i) - 'a']--;  // Decrease for str2
        }
        
        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for two strings
        System.out.print("Enter the first string: ");
        String str1 = sc.nextLine().toLowerCase(); // Convert to lowercase for case insensitivity
        
        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine().toLowerCase(); // Convert to lowercase

        // Check if they are anagrams
        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are NOT anagrams.");
        }

        sc.close();
    }
}
