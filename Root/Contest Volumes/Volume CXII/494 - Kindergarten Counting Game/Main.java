import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while (s.hasNext()) {
			char[] line = s.nextLine().toCharArray();
			long words = 0;
			boolean lastChar = false;
			boolean curChar = false;
			
			for (int i = 0; i < line.length; ++i) {
				if ((line[i] >= 'a' && line[i] <= 'z') || (line[i] >= 'A' && line[i] <= 'Z')) {
					curChar = true;
				}
				else {
					curChar = false;
				}
				
				if (!lastChar && curChar) {
					++words;
				}
				
				lastChar = curChar;
			}
			
			System.out.println(words);
		}
	}
}