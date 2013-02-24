import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int kases = s.nextInt();
        
        for (int k = 0; k < kases; ++k) {
            int coinNum = s.nextInt();
            int[] coins = new int[coinNum + 1];
            int coinSum = 0;
            
            for (int i = 1; i < coinNum + 1; ++i) {
                coins[i] = s.nextInt();
                coinSum += coins[i];
            }
            
            int half = (coinSum / 2) + 1;
            boolean[][] dp = new boolean[coinNum + 1][half];
            
            for (int i = 0; i < coinNum + 1; ++i) {
                for (int j = 0; j < half; ++j) {
                    if (coins[i] == j) {
                        dp[i][j] = true;
                        continue;
                    }
                    
                    if (i - 1 >= 0 && dp[i - 1][j]) {
                        dp[i][j] = true;
                        continue;
                    }
                    
                    if (j >= coins[i] && i - 1 >= 0 && dp[i - 1][j - coins[i]]) {
                        dp[i][j] = true;
                    }
                }
            }
            
            int splitVal = 0;
            
            for (int i = half - 1; i >= 0; --i) {
                if (dp[coinNum][i]) {
                    splitVal = i;
                    break;
                }
            }
            
            System.out.println(coinSum -  2 * splitVal);
        }
    }
}