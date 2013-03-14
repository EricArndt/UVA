import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        
        for (int m = 0; m < n; ++m) {
            int p = s.nextInt();
            
            int sets = (int)Math.pow(2, p);
            
            int[] party = new int[p];
            int[] partyPower = new int[p];
            
            int total = 0;
            for (int i = 0; i < p; ++i) {
                party[i] = s.nextInt();
                total += party[i];
            }
            
            int majority = (total + 1) / 2;
            
            for (int i = 0; i < sets; ++i) {
                int setVal = 0;
                
                for (int j = 0; j < p; ++j) {
                    if ((i & (1 << j)) > 0) {
                        setVal += party[j];
                    }
                }
                
                if (setVal >= majority) {
                    continue;
                }
                
                for (int j = 0; j < p; ++j) {
                    if ((i & (1 << j)) == 0 && setVal + party[j] >= majority) {
                        ++partyPower[j];
                    }
                }
            }
            
            for (int i = 0; i < p; ++i) {
                System.out.printf("party %d has power index %d\n", i + 1, partyPower[i]);
            }
            
            System.out.println();
        }
    }
}