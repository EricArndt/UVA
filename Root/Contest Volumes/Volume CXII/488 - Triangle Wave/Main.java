import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int kases = s.nextInt();
		
		while (kases > 0) {
			int a = s.nextInt();
			int f = s.nextInt();
			
			for (int i = 0; i < f; ++i) {
				for (int j = 1; j <= a; ++j) {
					for (int k = 0; k < j; ++k) {
						sb.append(j);
					}
					sb.append("\n");
				}
				
				for (int j = a - 1; j > 0; --j) {
					for (int k = 0; k < j; ++k) {
						sb.append(j);
					}
					sb.append("\n");
				}
				
				if (i + 1 < f) {
					sb.append("\n");
				}
			}
			
			--kases;
			
			if (kases > 0) {
				sb.append("\n");
			}
		}
		
		System.out.print(sb.toString());
	}
}