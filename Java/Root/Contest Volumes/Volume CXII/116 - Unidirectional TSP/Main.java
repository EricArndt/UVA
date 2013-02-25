import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while (s.hasNext()) {
            int row = s.nextInt();
            int col = s.nextInt();
            
            Node[][] grid = new Node[row][col];
            
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    grid[i][j] = new Node();
                    grid[i][j].value = s.nextInt();
                    grid[i][j].row = i;
                }
            }
            
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    if (j + 1 >= col) {
                        continue;
                    }
                    
                    grid[i][j].up = i - 1 < 0 ? grid[row - 1][j + 1] : grid[i - 1][j + 1];
                    grid[i][j].right = grid[i][j + 1];
                    grid[i][j].down = i + 1 >= row ? grid[0][j + 1] : grid[i + 1][j + 1];
                }
            }
            
            for (int j = col - 2; j >= 0; --j){
                for (int i = row - 1; i >= 0; --i) {               
                    Node[] n = {grid[i][j].up, grid[i][j].right, grid[i][j].down};
                    Arrays.sort(n);
                    
                    int best = Integer.MAX_VALUE;
                    for (int k = 0; k < 3; ++k) {
                        if (n[k].value < best){
                            best = n[k].value;
                            grid[i][j].from = n[k];
                        }
                    }
                    
                    grid[i][j].value += best;
                    
                }
            }
            
            int best = Integer.MAX_VALUE;
            int bestIndex = 0;
            
            for (int i = 0; i < row; ++i) {
                if (grid[i][0].value < best) {
                    best = grid[i][0].value;
                    bestIndex = i;
                }
            }
            
            Node bestNode = grid[bestIndex][0];
            Node currentBest = bestNode;
            System.out.print(currentBest.row + 1);
            
            while (currentBest.from != null) {
                currentBest = currentBest.from;
                System.out.print(" " + (currentBest.row + 1));
            }
            System.out.println();
            
            System.out.println(bestNode.value);
        }
    }
    
    static class Node implements Comparable<Node> {
        int row;
        int value;
        Node up;
        Node right;
        Node down;
        Node from;

        public int compareTo(Node n) {
            return this.row - n.row;
        }
    }
}