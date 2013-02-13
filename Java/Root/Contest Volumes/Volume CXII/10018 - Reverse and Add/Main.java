import java.util.*;

public class Main{ 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int kases = s.nextInt();
        while (kases > 0) {
            long num = s.nextLong();
            long reverseNum = 0;
            long result = 0;
            int count = 0;
            
            while (true) {
                reverseNum = reverse(num);
                result = num + reverseNum;
                
                ++count;
                
                if (isPalindrome(result)) {
                    break;
                }
                
                num = result;
            }
            
            System.out.println(count + " " + result);
            
            -- kases;
        }
    }
    
    public static long reverse(long num) {
        String numString = "" + num;
        
        String reversedNumString = "";
        for (int i = numString.length() - 1; i >= 0; --i){
            reversedNumString += numString.charAt(i);
        }
        
        return Long.parseLong(reversedNumString);
    }
    
    public static boolean isPalindrome(long num) {
        String numString = "" + num;
        
        boolean palindrome = true;
        
        for (int i = 0; i < numString.length(); ++i) {
            if (numString.charAt(i) != numString.charAt(numString.length() - 1 - i)) {
                palindrome = false;
                break;
            }
        }
        
        return palindrome;
    }
}