import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        
        int[] correct = new int[n];
        
        for (int i = 1; i <= n; ++i) {
            int in = s.nextInt() - 1;
            correct[in] = i;
        }
        
        while (s.hasNext()) {
            int[] student = new int[n];
            
            for (int i = 1; i <= n; ++i) {
                student[s.nextInt() - 1] = i;
            }
            
            int[][] grid = new int[n][n];
            
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    int up = 0;
                    int left = 0;
                    int diag = 0;
                    
                    if (i - 1 >= 0) {
                        up = grid[i - 1][j];
                    }
                    
                    if (j - 1 >= 0) {
                        left = grid[i][j - 1];
                    }
                    
                    if (i - 1 >= 0 && j - 1 >= 0){
                        diag = grid[i - 1][j - 1];
                    }
                    
                    int best = Math.max(up, left);
                    grid[i][j] = correct[i] == student[j] ? Math.max(diag + 1, best) : best;
                }
            }
            
            System.out.println(grid[n - 1][n - 1]);
        }
    }
}