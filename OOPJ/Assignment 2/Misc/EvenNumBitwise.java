public class EvenNumBitwise {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i += 2) {
            if ((i & 1) == 0) { // Check if the number is even using bitwise AND
                System.out.print(i + " ");
            }
        }
    }
}
