import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
                long[] nums = new long[1000001];
                
                for (int i = 1; i <= 1000000; ++i) {
                    long c = 0;
                    long n = i;
                    
                    while (n != 1) {
                        if (n % 2 == 0) {
                            n /= 2;
                        } else {
                            n = 3 * n + 1;
                        }
                        ++c;
                    }
                    
                    nums[i] = c;
                }
                
		while (s.hasNext()) {
			int n = s.nextInt();
                        int m = s.nextInt();
                        long max = 0;
                        
                        for (int i = n; i <= m; ++i) {
                            Math.max(max, nums[i]);
                        }
			
			System.out.println(n + " " + m + " " + max);
		}
	}
}