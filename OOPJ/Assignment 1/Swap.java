public class Swap {
    public static void main(String[] args) {
        // Swapping using a temporary variable
        int a = 10, b = 20;
        System.out.println("Before Swapping: a = " + a + ", b = " + b);
        
        int temp = a;
        a = b;
        b = temp;
        
        System.out.println("After Swapping (using temp variable): a = " + a + ", b = " + b);
        
        // Swapping without using a temporary variable
        a = 10;
        b = 20;
        System.out.println("Before Swapping: a = " + a + ", b = " + b);
        
        a = a + b;
        b = a - b;
        a = a - b;
        
        System.out.println("After Swapping (without temp variable): a = " + a + ", b = " + b);
    }
}