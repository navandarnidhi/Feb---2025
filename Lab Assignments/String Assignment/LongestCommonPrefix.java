import java.util.Scanner; 
 
public class LongestCommonPrefix { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
 
        System.out.print("Enter number of strings: "); 
        int n = sc.nextInt(); 
        sc.nextLine(); // Consume newline 
 
        String[] strs = new String[n]; 
        for (int i = 0; i < n; i++) { 
            System.out.print("Enter string " + (i + 1) + ": "); 
            strs[i] = sc.nextLine(); 
        } 
 
        String prefix = strs[0]; 
 
        for (int i = 1; i < n; i++) { 
            int j = 0; 
            while (j < prefix.length() && j < strs[i].length() && 
prefix.charAt(j) == strs[i].charAt(j)) { 
                j++; 
            } 
            prefix = prefix.substring(0, j); 
        } 
 
        System.out.println("Longest Common Prefix: " + prefix); 
    } 
} 
 