import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int c = s.nextInt();
        
        for (int k = 0; k < c; ++k) {
            String in = s.next();
            
            System.out.println(pop(in) ? 1 : 0);
        }
    }
    
    static boolean pop(String in) {
        if (in.length() == 0) {
            return true;
        }
        
        if (in.length() == 1) {
            return false;
        }
        
        ArrayList<String> groups = new ArrayList<String>();
        
        char currentChar = in.charAt(0);
        String current = "" + currentChar;
        
        for (int i = 1; i < in.length(); ++i) {
            if (in.charAt(i) == currentChar) {
                current += currentChar;
            }
            else {
                groups.add(current);
                currentChar = in.charAt(i);
                current = "" + currentChar;
            }
            
            if (i == in.length() - 1){
                groups.add(current);
            }
        }
        
        for (int i = 0; i < groups.size(); ++i) {
            String next = "";
            if (groups.get(i).length() == 1) {
                continue;
            }
            
            for (int j = 0; j < groups.size(); ++j) {
                if (i != j) {
                    next += groups.get(j);
                }
            }
            
            if (pop(next)) {
                return true;
            }
        }
        
        return false;
    }
}