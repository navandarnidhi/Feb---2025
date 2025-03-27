import java.util.Scanner;

public class ReverseString {

    public static String reverse(String str) {
        if (str.isEmpty() || str.length() == 1) { 
            return str; 
        } else {
			return reverse(str.substring(1)) + str.charAt(0);
		}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        String reversed = reverse(input);
        System.out.println("Reversed string: " + reversed);
        
        sc.close();
    }
}
