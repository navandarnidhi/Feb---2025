public class Arithmetic {
	public static void main(String args[]){
		int numerator = 10;
		int denominator = 0;

		try {
			int result = numerator / denominator;
			System.out.println("Result: " + result);
		}
		catch (ArithmeticException e) {
			System.out.println("Caught Arithmetic Execption..");
		}
		System.out.println("Program continues after handling execption. ");
	}
}