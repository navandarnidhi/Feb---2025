public class SumOfDigits {
    public static void main(String[] args) {
        int num = 1234;
        int sum = 0;
        
        while (num > 0) {
            sum += num % 10;  // Get the last digit
            num /= 10;       // Remove the last digit
        }
        
        System.out.println("Sum of digits: " + sum);
    }
}
