import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while (true) {
            int n = s.nextInt();
            
            if (n == 0) {
                break;
            }
            
            boolean bicol = true;
            
            Node[] graph = new Node[n];
            
            for (int i = 0; i < n; ++i) {
                graph[i] = new Node();
            }
            
            int c = s.nextInt();
            
            for (int i = 0; i < c; ++i) {
                int a = s.nextInt();
                int b = s.nextInt();
                
                graph[a].conn.add(graph[b]);
                graph[b].conn.add(graph[a]);
            }
            
            ArrayList<Node> list = new ArrayList<Node>();
            
            list.add(graph[0]);
            
            while (!list.isEmpty()) {
                Node curr = list.remove(0);
                curr.processed = true;
                
                boolean one = false;
                boolean two = false;
                
                for (int i = 0; i < curr.conn.size(); ++i) {
                    Node link = curr.conn.get(i);
                    
                    if (!link.processed) {
                        list.add(link);
                    }
                    
                    one |= link.color == 1;
                    two |= link.color == 2;
                }
                
                if (one && two) {
                    bicol = false;
                    break;
                }
                
                if (one) {
                    curr.color = 2;
                }
                
                if (two) {
                    curr.color = 1;
                }
                
                if (!one && !two) {
                    curr.color = 1;
                }
            }
            
            if (bicol) {
                System.out.println("BICOLORABLE.");
            }
            else {
                System.out.println("NOT BICOLORABLE.");
            }
        }
    }
    
    static class Node {
        boolean processed = false;
        int color = 0;
        ArrayList<Node> conn = new ArrayList<Node>();
    }
}