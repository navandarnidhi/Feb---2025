import java.util.Scanner; 
 
public class LongestRepeatingSubsequence { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter string: "); 
        String str = sc.nextLine(); 
        int n = str.length(); 
 
        int[][] dp = new int[n+1][n+1]; 
 
        for (int i = 1; i <= n; i++) { 
            for (int j = 1; j <= n; j++) { 
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) 
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                else 
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); 
            } 
        } 
 
        // Reconstruct the subsequence 
        int i = n, j = n; 
        String lrs = ""; 
        while (i > 0 && j > 0) { 
            if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) { 
                lrs = str.charAt(i - 1) + lrs; 
                i--; 
                j--; 
            } else if (dp[i - 1][j] > dp[i][j - 1]) { 
                i--; 
            } else { 
                j--; 
            } 
        } 
 
        System.out.println("Longest Repeating Subsequence: " + lrs); 
    }
}