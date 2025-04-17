import java.util.Scanner; 
 
public class LongestUniqueSubstring { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter string: "); 
        String str = sc.nextLine(); 
        int maxLength = 0; 
 
        for (int i = 0; i < str.length(); i++) { 
            boolean[] seen = new boolean[256]; 
            int length = 0; 
            for (int j = i; j < str.length(); j++) { 
                char c = str.charAt(j); 
                if (seen[c]) { 
                    break; 
                } else { 
                    seen[c] = true; 
                    length++; 
                } 
            } 
            if (length > maxLength) { 
                maxLength = length; 
            } 
        } 
 
        System.out.println("Longest length without repeating characters: " 
+ maxLength); 
    } 
} 