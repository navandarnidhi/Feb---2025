import java.util.Scanner; 
 
public class ContainsSubstring { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter main string: "); 
        String str = sc.nextLine(); 
        System.out.print("Enter substring: "); 
        String sub = sc.nextLine(); 
 
        boolean found = false; 
        for (int i = 0; i <= str.length() - sub.length(); i++) { 
            int j = 0; 
            while (j < sub.length() && str.charAt(i + j) == sub.charAt(j)) 
{ 
                j++; 
            } 
            if (j == sub.length()) { 
                found = true; 
                break; 
            } 
        } 
 
        System.out.println("Contains substring? " + found); 
    } 
} 