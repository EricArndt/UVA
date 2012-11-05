import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		HashMap<Long, Long> nums = new HashMap<Long, Long>(); 
		

		for (long i = 1; i <= 1000000; ++i) {
			long c = 0;
			long n = i;
					
			while (n != 1) {
				if (nums.containsKey(n)) {
					c += nums.get(n);
					break;
				}
				if (n % 2 == 0) {
					n /= 2;
				} else {
					n = 3 * n + 1;
				}

				++c;

			}
			
			nums.put(i, c);
					
		}

		while (s.hasNext()) {
			int n = s.nextInt();
			int m = s.nextInt();
			int min = Math.min(n, m);
			int maxN = Math.max(n, m);

			long max = 0;
						
			for (long i = min; i <= maxN; ++i) {
				long getI = nums.get(i);
				max = max > getI ? max : getI;
			}
			
			System.out.println(n + " " + m + " " + (max + 1));
		}
	}
}
