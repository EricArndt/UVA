import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while (s.hasNext()) {
            char[] s1 = s.next().toCharArray();
            char[] s2 = s.next().toCharArray();
            
            int[][] dp = new int[s1.length + 1][s2.length + 1];
            
            for (int i = 1; i < s1.length + 1; ++i) {
                for (int j = 1; j < s2.length + 1; ++j) {
                    dp[i][j] = Math.max(Math.max(dp[i - i][j], dp[i][j - 1]), s1[i - 1] == s2[j - 1] ? dp[i - 1][j - 1] + 1 : 0);
                }
            }
            
            System.out.println(dp[s1.length][s2.length] == s1.length ? "Yes" : "No");
        }
    }
}