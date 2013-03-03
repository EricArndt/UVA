import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int c = 1;
        while (true) {
            int n = s.nextInt();
            
            if (n < 3) {
                break;
            }
            
            double area = s.nextDouble();
            
            double sqAp = area / (n * Math.tan(2 * Math.acos(0) / n));
            double sqR = sqAp / ((Math.cos(2 * Math.acos(0) / n) * Math.cos(2 * Math.acos(0) / n)));
            double smallArea = 2 * Math.acos(0) * sqAp;
            double bigArea = 2 * Math.acos(0) * sqR;
           
         
            System.out.printf("Case %d: %.5f %.5f\n", c, bigArea - area, area - smallArea);
        
            ++c;
        }
    }
}