import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		
		boolean openQuote = true;
		while (s.hasNext()) {
			char[] in = s.nextLine().toCharArray();
			
			for (int i = 0; i < in.length; ++i) {
				if (in[i] == '"') {
					if (openQuote) {
						System.out.print("``");
					}
					else {
						System.out.print("''");
					}
					
					openQuote = !openQuote;
				}
				else {
					System.out.print(in[i]);
				}
			}
			
			System.out.println();
		}
	}
}