public class WrapperConversion {
    public static void main(String[] args) {
        Integer intObj = 50;
        Double doubleObj = intObj.doubleValue(); 
        System.out.println("Integer to Double: " + doubleObj);

        Double doubleNum = 123.45;
        Integer intNum = doubleNum.intValue(); 
        System.out.println("Double to Integer: " + intNum);
    }
}
