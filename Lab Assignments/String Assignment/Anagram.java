import java.util.Scanner; 
 
public class Anagram { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter first string: "); 
        String str1 = sc.nextLine(); 
        System.out.print("Enter second string: "); 
        String str2 = sc.nextLine(); 
 
        if(str1.length() != str2.length()) { 
            System.out.println("Not anagrams"); 
            return; 
        } 
 
        int[] count = new int[256]; 
        for(int i = 0; i < str1.length(); i++) { 
            count[str1.charAt(i)]++; 
            count[str2.charAt(i)]--; 
        } 
 
        for(int i = 0; i < 256; i++) { 
            if(count[i] != 0) { 
                System.out.println("Not anagrams"); 
                return; 
            } 
        } 
        System.out.println("Strings are anagrams"); 
    } 
}