public class LargestDigit {
    public static void main(String[] args) {
        int num = 4825, maxDigit = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit > maxDigit) {
                maxDigit = digit;
            }
            num /= 10;
        }
        System.out.println("Largest digit in 4825: " + maxDigit);
    }
}
