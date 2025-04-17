import java.util.Scanner; 
 
public class RabinKarp { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter text: "); 
        String text = sc.nextLine(); 
        System.out.print("Enter pattern: "); 
        String pattern = sc.nextLine(); 
 
        int d = 256; 
        int q = 101; // A prime number 
        int m = pattern.length(); 
        int n = text.length(); 
        int i, j; 
        int p = 0, t = 0, h = 1; 
 
        for (i = 0; i < m - 1; i++) 
            h = (h * d) % q; 
 
        for (i = 0; i < m; i++) { 
            p = (d * p + pattern.charAt(i)) % q; 
            t = (d * t + text.charAt(i)) % q; 
        } 
 
        for (i = 0; i <= n - m; i++) { 
            if (p == t) { 
                for (j = 0; j < m; j++) { 
                    if (text.charAt(i + j) != pattern.charAt(j)) 
                        break; 
                } 
                if (j == m) 
                    System.out.println("Pattern found at index: " + i); 
            } 
            if (i < n - m) { 
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % 
q; 
                if (t < 0) 
                    t += q; 
            } 
        } 
    } 
} 