public class AtLeastTwoTrue {
    public static void main(String[] args) {
        boolean a = true, b = false, c = true;

        boolean result = (a && b) || (b && c) || (a && c);

        System.out.println("At least two are true: " + result);
    }
}
