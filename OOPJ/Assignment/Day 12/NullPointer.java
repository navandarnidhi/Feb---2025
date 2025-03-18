public class NullPointer{
	public static void main(String args[]){
		String str = null;

		try{
			int length = str.length();
			System.out.println("Length of String: "+ length);
		}
		catch (NullPointerException e){
			System.out.println("Caught NullPointerException..");
		}
		System.out.println("Program continues after handling exception.");
	}
}