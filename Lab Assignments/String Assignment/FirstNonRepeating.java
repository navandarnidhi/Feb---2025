import java.util.Scanner;

public class FirstNonRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();


        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int count = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == c) {
                    count++;
                }
            }
            if(count == 1) {
                System.out.println("First non-repeating character: " + c);
                return;
            }
        }
        System.out.println("No non-repeating character found.");
    }
}

/*
import java.util.Scanner;

public class FirstNonRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Traverse string to count frequency
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean isUnique = true;

            // Check if character is repeating
            for (int j = 0; j < str.length(); j++) {
                if (i != j && str.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }

            // Print and exit if found non-repeating
            if (isUnique) {
                System.out.println("First non-repeating character: " + c);
                return;
            }
        }

        System.out.println("No non-repeating character found.");
    }
}


*/