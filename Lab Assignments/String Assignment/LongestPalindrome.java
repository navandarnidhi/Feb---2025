import java.util.Scanner; 
 
public class LongestPalindrome { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter string: "); 
        String s = sc.nextLine(); 
 
        int start = 0, maxLen = 1; 
        for (int i = 0; i < s.length(); i++) { 
            // Odd length palindrome 
            int l = i, r = i; 
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) 
{ 
                if (r - l + 1 > maxLen) { 
                    start = l; 
                    maxLen = r - l + 1; 
                } 
                l--; r++; 
            } 
 
            // Even length palindrome 
            l = i; r = i + 1; 
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) 
{ 
                if (r - l + 1 > maxLen) { 
                    start = l; 
                    maxLen = r - l + 1; 
                } 
                l--; r++; 
            } 
        } 
 
        System.out.print("Longest Palindromic Substring: "); 
        for (int i = start; i < start + maxLen; i++) { 
            System.out.print(s.charAt(i)); 
        } 
    } 
} 
 