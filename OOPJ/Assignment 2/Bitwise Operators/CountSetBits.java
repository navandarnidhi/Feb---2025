public class CountSetBits {
    public static void main(String[] args) {
        int n = 29; // Binary: 11101
        int count = 0;

        while (n > 0) {
            n = n & (n - 1);
            count++;
        }

        System.out.println("Number of set bits: " + count);
    }
}
