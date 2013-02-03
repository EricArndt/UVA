import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		
		while (s.hasNext()) {
			int n = s.nextInt();
			
			
			
			int[] nums = new int[n];
			
			for (int i = 0; i < n; ++i) {
				nums[i] = s.nextInt();
			}
			
			if (n == 1) {
				System.out.println("Jolly");
				continue;
			}
			
			boolean[] jolly = new boolean[n];
			for (int i = 0; i < n - 1; ++i) {
				int diff = Math.abs(nums[i] - nums[i + 1]);
				
				if (diff < 1 || diff >= n) {
					break;
				}
				
				jolly[diff] = true;
			}
			
			boolean j = true;
			
			for (int i = 1; i < jolly.length; ++i) {
				if (!jolly[i]) {
					j = false;
					break;
				}
			}
			
			if (j) {
				System.out.println("Jolly");
			}
			else {
				System.out.println("Not jolly");
			}
		}
	}
}