public class ArrayIndex {
	public static void main(String args[]){
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};

		try {
			int value = numbers[10];
			System.out.println("Value: " + value);
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Caught ArrayIndexOfBound..");
		}
		System.out.println("Program continues after Handling Exception");
	}
}