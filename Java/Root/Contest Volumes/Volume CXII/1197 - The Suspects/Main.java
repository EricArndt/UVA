import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while (true) {
            int n = s.nextInt();
            int m = s.nextInt();
            
            if (n == 0 && m == 0) {
                break;
            }
            ArrayList<HashSet<Integer>> sets = new ArrayList<HashSet<Integer>>(m);
            
            for (int i = 0; i < m; ++i) {
                int num = s.nextInt();
                HashSet<Integer> hs = new HashSet<Integer>(num);
                
                for (int j = 0; j < num; ++j) {
                    hs.add(s.nextInt());
                }
                
                sets.add(hs);
            }
            
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (i != j) {
                        HashSet<Integer> a = sets.get(i);
                        HashSet<Integer> b = sets.get(j);
                        
                        HashSet<Integer> smaller;
                        HashSet<Integer> larger;
                        
                        if (a.size() < b.size()) {
                            smaller = a;
                            larger = b;
                        }
                        else {
                            smaller = b;
                            larger = a;
                        }
                        
                        for (int k : smaller) {
                            if (larger.contains(k)) {
                                larger.addAll(smaller);
                                smaller.clear();
                                break;
                            }
                        }
                    }
                }
            }
            
            int count = 1;
            
            for (HashSet<Integer> set : sets) {
                if (set.contains(0)) {
                    count = set.size();
                    break;
                }
            }
            
            System.out.println(count);
        }
    }
}