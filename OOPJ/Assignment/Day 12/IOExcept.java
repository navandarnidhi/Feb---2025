import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOExcept {
    public static void main(String[] args) {
		
        String fileName = "xyz.txt";
        try{
			FileReader filename1 = new FileReader(fileName);
            int line = filename1.read();
            System.out.println("File content: " + line);
        } catch (IOException e) {
            System.out.println("Caught an Exception: IOException.");
        }
		
    }
}