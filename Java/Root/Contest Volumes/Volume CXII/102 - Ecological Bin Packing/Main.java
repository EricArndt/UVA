import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(0, "B");
		hm.put(1, "G");
		hm.put(2, "C");
		
		while (s.hasNext()) {
			int[] bins = new int[9];
			
			for (int i = 0; i < 9; ++i) {
				int n = s.nextInt();
				bins[i] = n;
			}
			
			int smallest = Integer.MAX_VALUE;
			ArrayList<String> answers = new ArrayList<String>();
			
			for (int i = 0; i < 3; ++i) {
				for (int j = 3; j < 6; ++j){
					if ((i % 3) == (j % 3)) {
						continue;
					}
					
					for (int k = 6; k < 9; ++k){
						if ((i % 3) == (k % 3) || (j % 3) == (k % 3)) {
							continue;
						}
						
						int sum = 0;
						for (int l = 0; l < 9; ++l) {
							if (l == i || l == j || l == k) {
								continue;
							}
							
							sum += bins[l];
						}
						
						if (sum < smallest) {
							smallest = sum;
							answers.clear();
							String ans = hm.get(i % 3) + hm.get(j % 3) + hm.get(k % 3);
							answers.add(ans);
						}
						else if (sum == smallest) {
							String ans = hm.get(i % 3) + hm.get(j % 3) + hm.get(k % 3);
							answers.add(ans);
						}
					}
				}
			}
			
			Collections.sort(answers);
			
			System.out.println(answers.get(0) + " " + smallest);
		}
	}
}