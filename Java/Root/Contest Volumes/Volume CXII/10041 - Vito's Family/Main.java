import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int k = s.nextInt();
        
        for (int t = 0; t < k; ++t) {
            int r = s.nextInt();
            int[] relatives = new int[r];
            
            for (int i = 0; i < r; ++i) {
                relatives[i] = s.nextInt();
            }
            
            Arrays.sort(relatives);
            
            long bestLoc;
            
            if (r % 2 == 0) {
                bestLoc = (relatives[r/2] + relatives[(r - 1)/2]) / 2;
            }
            else {
                bestLoc = relatives[r / 2];
            }
            
            int distance = 0;
            for (int i = 0; i < r; ++i) {
                distance += Math.abs(relatives[i] - bestLoc);
            }
            
            System.out.println(distance);
        }
    }
}