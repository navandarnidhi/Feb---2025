public class EvenOdd {
    public static void main(String[] args) {
        if (args.length > 0) {
            int num = Integer.parseInt(args[0]);
            if (num % 2 == 0) {
                System.out.println(num + " is even.");
            } else {
                System.out.println(num + " is odd.");
            }
        } else {
            System.out.println("Please provide a number as a command-line argument.");
        }
    }
}