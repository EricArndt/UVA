import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int kases = s.nextInt();
		s.nextLine();
		
		while (kases > 0) {
			String line = s.nextLine();
			
			if (line == null || line.equals("")) {
				System.out.println("Yes");
				--kases;
				continue;
			}
			
			char[] li = line.toCharArray();
			
			Stack<Character> stack = new Stack<Character>();
			boolean valid = true;
			
			for (int i = 0; i < li.length; ++i) {
				if (li[i] == '(' || li[i] == '[') {
					stack.add(li[i]);
				}
				else if (li[i] == ')' || li[i] == ']') {
					if (stack.size() == 0) {
						valid = false;
						break;
					}
					
					char c = stack.pop();
					if ((c == '(' && li[i] != ')') || (c == '[' && li[i] != ']')) {
						valid = false;
						break;
					}
				}
			}
			
			if (stack.size() > 0)
			{
				valid = false;
			}
			
			if (valid) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
			
			--kases;
		}
	}
}