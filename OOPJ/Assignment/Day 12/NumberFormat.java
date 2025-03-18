public class NumberFormat {
	public static void main(String args[]){
		String invalidNum = "abc123";

		try {
			int number = Integer.parseInt(invalidNum);
			System.out.println("Converted number: " + number);
		}
		catch (NumberFormatException e){
   			System.out.println("Caught NumberFormatException..");
		}
		System.out.println("Program continues after handling exception.");
	}
}