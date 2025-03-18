public class IllegalArgument {
	public static void setAge(int age){
		if (age < 0 || age > 150){
			throw new IllegalArgumentException("Age cannot be negative or greater than 150");
		}
		System.out.println("Age set to: " + age);
	}
	
	public static void main(String args[]){
		try {
			setAge(-5);		
		}
		catch (IllegalArgumentException e) {
			System.out.println("Caught IllegalArgumentException: " + e.getMessage());
		}

		try {
			setAge(200);		
		}
		catch (IllegalArgumentException e) {
			System.out.println("Caught IllegalArgumentException: " + e.getMessage());
		}

		try {
			setAge(30);		
		}
		catch (IllegalArgumentException e) {
			System.out.println("Caught IllegalArgumentException: " + e.getMessage());
		}

		System.out.println("Program continues after handling exception");
	}
}