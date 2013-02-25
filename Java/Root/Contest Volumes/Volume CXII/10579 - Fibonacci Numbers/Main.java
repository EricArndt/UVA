import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        char[][] fibbs = new char[5000][1000];
        
        fibbs[0][0] = '1';
        fibbs[1][0] = '1';
        
        for (int i = 1; i < 1000; ++i) {
            fibbs[0][i] = '0';
            fibbs[1][i] = '0';
        }
        
        for (int i = 2; i < 5000; ++i) {
            char[] a = fibbs[i - 1];
            char[] b = fibbs[i - 2];
            char[] temp = new char[1000];
            int carry = 0;
            
            for (int j = 0; j < 1000; ++j) {
                int val = (a[j] - '0') + (b[j] - '0') + carry;
                temp[j] = (char)((val % 10) + '0');
                
                if (val >= 10) {
                    carry = 1;
                }
                else {
                    carry = 0;
                }
            }
            
            fibbs[i] = temp;
        }
        
        while (s.hasNext()) {
            int in = s.nextInt();
            boolean leadingZero = true;
            
            for (int i = 999; i >= 0; --i) {
                char c = fibbs[in - 1][i];
                
                if (c != '0') {
                    leadingZero = false;
                }
                
                if (!leadingZero) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}