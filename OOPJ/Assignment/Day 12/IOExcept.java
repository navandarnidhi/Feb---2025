import java.io.*;

public class IOExcept {

	public static void main(String args[]){
	
	File file = new File("abc.txt");

	try {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
		} catch (IOException e) {
			System.out.println("Caught IOException..");
		}

		System.out.println("Program continues after handling exception.");
	}
}
