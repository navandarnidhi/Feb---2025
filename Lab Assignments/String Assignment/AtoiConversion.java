import java.util.Scanner; 
 
public class AtoiConversion { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter a numeric string: "); 
        String str = sc.nextLine(); 
 
        int result = 0; 
        boolean isNegative = false; 
        int i = 0; 
 
        if(str.charAt(0) == '-') { 
            isNegative = true; 
            i = 1; 
        } 
 
        for(; i < str.length(); i++) { 
            char c = str.charAt(i); 
            if(c >= '0' && c <= '9') { 
                result = result * 10 + (c - '0'); 
            } else { 
                System.out.println("Invalid input"); 
                return; 
            } 
        } 
 
        if(isNegative) { 
            result = -result; 
        } 
 
        System.out.println("Converted integer: " + result); 
    } 
} 