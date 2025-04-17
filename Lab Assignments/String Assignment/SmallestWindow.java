import java.util.Scanner; 
 
public class SmallestWindow { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter main string: "); 
        String str = sc.nextLine(); 
        System.out.print("Enter pattern: "); 
        String pat = sc.nextLine(); 
 
        int[] patFreq = new int[256]; 
        int[] strFreq = new int[256]; 
        for (int i = 0; i < pat.length(); i++) { 
            patFreq[pat.charAt(i)]++; 
        } 
 
        int start = 0, startIndex = -1, minLen = Integer.MAX_VALUE, count 
= 0; 
        for (int end = 0; end < str.length(); end++) { 
            char c = str.charAt(end); 
            strFreq[c]++; 
 
            if (strFreq[c] <= patFreq[c]) { 
                count++; 
            } 
 
            if (count == pat.length()) { 
                while (strFreq[str.charAt(start)] > 
patFreq[str.charAt(start)]) { 
                    strFreq[str.charAt(start)]--; 
                    start++; 
                } 
 
                int len = end - start + 1; 
                if (len < minLen) { 
                    minLen = len; 
                    startIndex = start; 
                } 
            } 
        } 
 
        if (startIndex == -1) { 
            System.out.println("No such window exists"); 
        } else { 
            System.out.print("Smallest window: "); 
            for (int i = startIndex; i < startIndex + minLen; i++) { 
                System.out.print(str.charAt(i)); 
            } 
            System.out.println(); 
        } 
    } 
} 
 