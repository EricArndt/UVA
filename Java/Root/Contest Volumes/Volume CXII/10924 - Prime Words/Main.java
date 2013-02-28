import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean[] primes = generate(52 * 20);
        
        while (s.hasNext()) {
            char[] in = s.next().toCharArray();
            
            int sum = 0;
            
            for (int i = 0; i < in.length; ++i) {
                sum += in[i] > 'Z' ? (in[i] - 'a') + 1 : (in[i] - 'A') + 27; 
            }
            
            System.out.println("It is" + (primes[sum] ? " not " : " ") + "a prime word.");
        }
    }
    
    static boolean[] generate(int n) {
		boolean[] primeList = new boolean[n + 1];

		if (n <= 2) {
			return null;
		}

		primeList[0] = true;
		primeList[1] = false;

		for (int i = 2; i * i <= n; ++i) {
			if (!primeList[i]) {
				for (int j = i; i * j <= n; ++j) {
					primeList[i * j] = true;
				}
			}
		}

		return primeList;
	}
}