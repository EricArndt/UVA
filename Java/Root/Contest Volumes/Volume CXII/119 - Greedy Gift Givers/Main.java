import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean first = true;
        
        while (s.hasNext()) {
            if (!first) {
                System.out.println();
            }
            first = false;
            int n = s.nextInt();
            String[] names = new String[n];
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            
            for (int i = 0; i < n; ++i) {
                names[i] = s.next();
                hm.put(names[i], 0);
            }
            
            for (int i = 0; i < n; ++i) {
                String name = s.next();
                int money = s.nextInt();
                int friends = s.nextInt();
                
                if (friends == 0) {
                    continue;
                }
                
                int val = hm.get(name);
                val -= money;
                val += money % friends;
                hm.put(name, val);
                
                for (int j = 0; j < friends; ++j) {
                    String friend = s.next();
                    int fVal = hm.get(friend);
                    fVal += money / friends;
                    hm.put(friend, fVal);
                }
            }
            
            for (int i = 0; i < n; ++i) {
                System.out.println(names[i] + " " + hm.get(names[i]));
            }
        }
    }
}