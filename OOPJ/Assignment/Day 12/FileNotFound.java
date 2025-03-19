import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class FileNotFound {
    public static void main(String[] args) { 
        try{
		String fileName = "xyz.txt";
		FileReader fileReader = new FileReader(fileName);
		int line = fileReader.read();
            	System.out.println("File content: " + line);
		fileReader.close();
			
        } catch (FileNotFoundException e) {
            System.out.println("Caught an Exception: FileNotFoundException.");
        }
    }
}