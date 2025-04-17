import java.util.Scanner; 
 
public class WordCount { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter a sentence: "); 
        String str = sc.nextLine(); 
        int count = 0; 
        boolean word = false; 
 
        for(int i = 0; i < str.length(); i++) { 
            if(str.charAt(i) != ' ' && !word) { 
                word = true; 
                count++; 
            } else if(str.charAt(i) == ' ') { 
                word = false; 
            } 
        } 
 
        System.out.println("Word count: " + count); 
    } 
}