import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.print("Enter character to count: ");
        char ch = sc.next().charAt(0);

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ch) {
                count++;
            }
        }

        System.out.println("Character '" + ch + "' occurred " + count + " times.");
    }
}

/*
import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.print("Enter character to count: ");
        char ch = sc.next().charAt(0);

        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == ch) count++;
        }
        System.out.println("Count of '" + ch + "': " + count);
    }
}

*/