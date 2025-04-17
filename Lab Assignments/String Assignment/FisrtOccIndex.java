import java.util.Scanner; 
 
public class FisrtOccIndex { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter main string: "); 
        String str = sc.nextLine(); 
        System.out.print("Enter substring: "); 
        String sub = sc.nextLine(); 
 
        int index = -1; 
        for (int i = 0; i <= str.length() - sub.length(); i++) { 
            int j = 0; 
            while (j < sub.length() && str.charAt(i + j) == sub.charAt(j)) 
{ 
                j++; 
            } 
            if (j == sub.length()) { 
                index = i; 
                break; 
            } 
        } 
 
        System.out.println("Index of first occurrence: " + index); 
    } 
}