public class AbsoluteValue {
    public static void main(String[] args) {
        int num = -15;

        int mask = num >> 31;  // Mask is -1 if num is negative, 0 if positive
        int absValue = (num + mask) ^ mask;

        System.out.println("Absolute value: " + absValue);
    }
}
