import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        
        int n = s.nextInt();
        
        for (int i = 0; i < n; ++i) {
            int num = s.nextInt();
            int[] ages = new int[num];
            for (int j = 0; j < num; ++j) {
                ages[j] = s.nextInt();
            }
            
            System.out.printf("Case %d: %d\n", i + 1, ages[num / 2]);
        }
    }
}