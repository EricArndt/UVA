import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while (true) {
            String str = s.next();
            
            if (str.equals("0")) {
                break;
            } 
            
            long num = 0;
            
            int count = 1;
            
            for (int i = str.length() - 1; i >= 0; --i) {
                int pow = 2;
                
                for (int j = 1; j < count; ++j) {
                    pow *= 2;
                }
                
                pow -= 1;
                
                num += pow * (str.charAt(i) - '0');
                ++count;
            }
            
            System.out.println(num);
        }
    }
}