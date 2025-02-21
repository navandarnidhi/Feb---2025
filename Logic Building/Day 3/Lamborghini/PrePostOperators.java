public class PrePostOperators {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int result = ++x - y--;
        System.out.println("x after pre-increment: " + x);
        System.out.println("y after post-decrement: " + y);
        System.out.println("Result of expression (++x - y--): " + result);
    }
}
