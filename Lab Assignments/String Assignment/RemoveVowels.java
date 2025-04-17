import java.util.Scanner; 
 
public class RemoveVowels { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter a string: "); 
        String str = sc.nextLine(); 
        String result = ""; 
 
        for(int i = 0; i < str.length(); i++) { 
            char c = str.charAt(i); 
            if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && 
               c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') { 
                result = result + c; 
            } 
        } 
 
        System.out.println("String without vowels: " + result); 
    } 
} 