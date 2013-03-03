import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while (true) {
            int n = s.nextInt();
            int m = s.nextInt();
            
            if (n == 0 && m == 0) {
                break;
            }
            
            Task[] tasks = new Task[n];
            
            for (int i = 0; i < n; ++i) {
                tasks[i] = new Task();
            }
            
            for (int i = 0; i < m; ++i) {
                int a = s.nextInt() - 1;
                int b = s.nextInt() - 1;
                
                tasks[a].precedes.add(tasks[b]);
                ++tasks[b].precedeCount;
            }
            
            for (int i = 0; i < n - 1; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (tasks[j] != null && tasks[j].precedeCount == 0) {
                        System.out.print((j + 1) + " ");
                        
                        for (Task t : tasks[j].precedes) {
                            --t.precedeCount;
                        }
                        
                        tasks[j] = null;
                        
                        break;
                    }
                }
            }
            
            for (int j = 0; j < n; ++j) {
                    if (tasks[j] != null && tasks[j].precedeCount == 0) {
                        System.out.println(j + 1);
                        break;
                    }
                }
        }
    }
    
    static class Task {
        ArrayList<Task> precedes = new ArrayList<Task>();
        int precedeCount = 0;
    }
}