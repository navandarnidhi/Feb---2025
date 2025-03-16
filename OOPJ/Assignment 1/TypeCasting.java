public class TypeCasting {
    public static void main(String[] args) {
        // Implicit Casting (Widening)
        int intVal = 100;
        double doubleVal = intVal; 
        System.out.println("Implicit Casting (int to double): " + doubleVal);

        // Explicit Casting (Narrowing)
        double doubleNum = 99.99;
        int intNum = (int) doubleNum; 
        System.out.println("Explicit Casting (double to int): " + intNum);
    }
}
