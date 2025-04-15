import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            boolean isDuplicate = false;

            for (int j = 0; j < result.length(); j++) {
                if (ch == result.charAt(j)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                result += ch;
            }
        }

        System.out.println("String without duplicates: " + result);
    }
}

/*
import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : input.toCharArray()) {
            if (set.add(c)) {
                result.append(c);
            }
        }
        System.out.println("Without duplicates: " + result);
    }
}

*/