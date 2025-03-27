import java.util.Scanner;
public class PowerFunction {
    public static int power(int b, int n) {
        if (n == 0 ) {  
            return 1; 
        }
        return b * power(b, n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
   
        System.out.print("Enter base (b): ");
        int b = sc.nextInt();
        System.out.print("Enter exponent (n): ");
        int n = sc.nextInt();
        int result = power(b, n);
        System.out.println(b + "^" + n + " = " + result);
        sc.close();
    }
}
