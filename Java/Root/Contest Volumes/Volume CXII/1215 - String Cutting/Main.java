import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int num = s.nextInt();
        
        for (int nu = 0; nu < num; ++nu) {
            int n = s.nextInt();
            int[] cuts = new int[n];
            
            for (int i = 0; i < n; ++i) {
                cuts[i] = s.nextInt();
            }
            
            String str = s.next();
            int cost = 0;
            
            for (int i = 0; i < n; ++i) {
                HashSet<Character> lowerSet = new HashSet<Character>();
                HashSet<Character> upperSet = new HashSet<Character>();
                
                int lowerBound = 0;
                int upperBound = str.length();
                
                for (int j = i - 1; j >= 0; --j) {
                    if (cuts[j] > lowerBound && cuts[j] < cuts[i]) {
                        lowerBound = cuts[j];
                    }
                    
                    if (cuts[j] < upperBound && cuts[j] > cuts[i]) {
                        upperBound = cuts[j];
                    }
                }
                
                for (int j = lowerBound; j < cuts[i]; ++j) {
                    lowerSet.add(str.charAt(j));
                }
                
                for (int j = upperBound - 1; j >= cuts[i]; --j) {
                    upperSet.add(str.charAt(j));
                }
                
                for (char c : lowerSet) {
                    if (!upperSet.contains(c)) {
                        ++cost;
                    }
                }
                
                for (char c : upperSet) {
                    if (!lowerSet.contains(c)) {
                        ++cost;
                    }
                }
            }
            
            System.out.println(cost);
        }
    }
}