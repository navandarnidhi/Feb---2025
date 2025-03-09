public class DivisibilityBy3 {
    public static void main(String[] args) {
        int num = 21;
        
        while (num > 3) {
            num = num - 3;
        }
        
        if (num == 3 || num == 0) {
            System.out.println("Divisible by 3");
        } else {
            System.out.println("Not divisible by 3");
        }
    }
}
