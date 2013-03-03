import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int count = s.nextInt();             
        
        for (int c = 1; c <= count; ++c) {
            Stack<String> pile = new Stack<String>();
            
            for (int i = 0; i < 52 - 25; ++i) {
                pile.add(s.next());
            }
            
            LinkedList<String> hand = new LinkedList<String>();
            
            for (int i = 0; i < 25; ++i) {
                hand.add(s.next());
            }
            
            int y = 0;
            
            for (int i = 0; i < 3; ++i) {
                char[] card = pile.pop().toCharArray();
                int value = card[0] >= '2' && card[0] <= '9' ? card[0] - '0' : 10;
                y += value;
                
                for (int j = 0; j < 10 - value; ++j) {
                    pile.pop();
                }
            }
            
            Stack<String> temp = new Stack<String>();
            
            while (!hand.isEmpty()) {
                pile.add(hand.pop());
            }
            
            System.out.printf("Case %d: %s\n", c, pile.elementAt(y - 1));
        }
    }
}