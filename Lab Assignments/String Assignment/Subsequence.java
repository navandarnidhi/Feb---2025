import java.util.Scanner; 
 
public class Subsequence { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter string s: "); 
        String s = sc.nextLine(); 
        System.out.print("Enter string t: "); 
        String t = sc.nextLine(); 
 
        int i = 0, j = 0; 
        while (i < s.length() && j < t.length()) { 
            if (s.charAt(i) == t.charAt(j)) { 
                i++; 
            } 
            j++; 
        } 
 
        if (i == s.length()) { 
            System.out.println("true"); 
        } else { 
            System.out.println("false"); 
        } 
    } 
} 