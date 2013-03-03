import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while (true) {
            int n = s.nextInt();
            
            if (n == 0) {
                break;
            }
            
            int cuts = 0;
            int day = 1;
            
            while (n > 1 && day < n) {
                ++cuts;
                
                n -= day;
                ++day;
            }
            
            System.out.println(cuts);
        }
    }
}