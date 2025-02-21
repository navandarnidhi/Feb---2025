public class FibonacciSequence {
    public static void main(String[] args) {
        int a = 0, b = 1;
        System.out.print("Fibonacci sequence up to 21: " + a + " " + b + " ");
        int next = a + b;
        while (next <= 21) {
            System.out.print(next + " ");
            a = b;
            b = next;
            next = a + b;
        }
    }
}
