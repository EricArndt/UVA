import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while (true) {
			int n1 = s.nextInt();
			int n2 = s.nextInt();
		
			if (n1 == 0 && n2 == 0) {
				break;
			}
		
			int[] num1 = new int[10];
			int[] num2 = new int[10];
			
			for (int i = 0; i < 10; ++i) {
				int div = (int)Math.pow(10, 10 - i - 1);
				num1[i] = n1 / (div);
				num2[i] = n2 / (div);
				
				n1 = n1 % div;
				n2 = n2 % div;
			}
			
			int carries = 0;
			int carry = 0;
			
			for (int i = 9; i >= 0; --i) {
				if (num1[i] + num2[i] + carry > 9) {
					++carries;
				}
				
				carry = (num1[i] + num2[i] + carry) / 10;
			}
			
			if (carries == 0) {
				System.out.println("No carry operation.");
			}
			else if (carries == 1) {
				System.out.println("1 carry operation.");
			}
			else {
				System.out.println(carries + " carry operations.");
			}
		}
	}
}