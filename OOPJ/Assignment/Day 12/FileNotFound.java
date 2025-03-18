import java.io.*;

public class FileNotFound {
    public static void readFile(String filePath) throws FileNotFoundException, IOException {
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        readFile("non_existent_file.txt");
        System.out.println("Program continues after handling exception.");
    }
}
