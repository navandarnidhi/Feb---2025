public class SwapOddEvenBits {
    public static void main(String[] args) {
        int x = 23; // Binary: 10111

        int evenBits = x & 0xAAAAAAAA; // Mask even bits (10101010...)
        int oddBits = x & 0x55555555;  // Mask odd bits (01010101...)

        int swapped = (evenBits >> 1) | (oddBits << 1);

        System.out.println("Original number: " + x);
        System.out.println("After swapping odd and even bits: " + swapped);
    }
}
