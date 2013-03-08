import java.util.*;

public class Main {
    static int currentSets;
    static final int TIME = 280;
    static final int PEOPLE = 3;
    static Problem[][] probs;
    static int[][][] grid = new int[(int)Math.pow(2, 12)][TIME + 1][3];;
    static int n;
    
    public static void main (String[] args) {     
        Scanner s = new Scanner(System.in);
           
        int c = s.nextInt();
        
        for (int cases = 0; cases < c; ++cases) {
            n = s.nextInt();
            
            currentSets = (int)Math.pow(2, n);
            
            probs = new Problem[PEOPLE][n];
            
            for (int i = 0; i < 3; ++i) {
                probs[i] = new Problem[n];
                
                for (int j = 0; j < n; ++j) {
                    probs[i][j] = new Problem(j, s.nextInt());
                }
                
                Arrays.sort(probs[i]);
            }
            
            // reset
            for (int i = 0; i < currentSets; ++i) {
                for (int j = 0; j <= TIME; ++j) {
                    for (int k = 0; k < PEOPLE; ++k) {
                        grid[i][j][k] = Integer.MIN_VALUE;
                    }
                }
            }
            
            // do DP with memoization
            int best = Math.max(recursiveDP(currentSets - 1, TIME, 0), Math.max(recursiveDP(currentSets - 1, TIME, 1), recursiveDP(currentSets - 1, TIME, 2)));
            System.out.println(best);
        }
    }
    
    static int recursiveDP(int set, int time ,int solver) {
        // we already calculated it
        if (grid[set][time][solver] != Integer.MIN_VALUE) {
            return grid[set][time][solver];
        }
        
        // calculate the best we can do
        int best = 0;
        
        // can you solve a problem with the remaining set?
        for (int i = 0; i < n; ++i) {
            // best problem for you to solve
            if ((set & (1 << probs[solver][i].id)) > 0) {
                if (probs[solver][i].time <= time) {
                    // you can solve your best problem left
                    int solveTime = probs[solver][i].time;
                    int setWithoutProblem = set & ~(1 << probs[solver][i].id);
                    best = Math.max(0, Math.max(recursiveDP(setWithoutProblem, time - solveTime, (solver + 1) % PEOPLE), recursiveDP(setWithoutProblem, time - solveTime, (solver + 2) % PEOPLE))) + 1;
                    break;
                }
            }
        }
        
        // save in memo table
        grid[set][time][solver] = best;
        
        return best;
    }
    
    static class Problem implements Comparable<Problem> {
        int id;
        int time;
        
        Problem(int id, int time) {
            this.id = id;
            this.time = time;
        }

        public int compareTo(Problem t) {
            return ((Integer)this.time).compareTo(t.time);
        }
    }
}