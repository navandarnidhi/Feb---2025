public class LargestOfThree {
    public static void main(String[] args) {
        int a = 10; // Example number a
        int b = 20; // Example number b
        int c = 15; // Example number c
        if (a >= b && a >= c) {
            System.out.println("The largest number is: " + a);
        } else if (b >= a && b >= c) {
            System.out.println("The largest number is: " + b);
        } else {
            System.out.println("The largest number is: " + c);
        }
    }
}
