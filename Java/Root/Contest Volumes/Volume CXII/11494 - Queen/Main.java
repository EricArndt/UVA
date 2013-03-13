import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while (true) {
            int x1 = s.nextInt();
            int y1 = s.nextInt();
            int x2 = s.nextInt();
            int y2 = s.nextInt();
            
            if (x1 == 0 && y1 == 0 && x2 == 0 && y2 == 0) {
                break;
            }
            
            if (x1 == x2 && y1 == y2) {
                System.out.println(0);
            }
            else {
                int rise = Math.abs(y1 - y2);
                int run = Math.abs(x1 - x2);
                
                if (rise == run) {
                    System.out.println(1);
                }
                else if (x1 != x2 && y1 == y2) {
                    System.out.println(1);
                }
                else if (x1 == x2 && y1 != y2) {
                    System.out.println(1);
                }
                else {
                    System.out.println(2);
                }
            }
        }
    }
}