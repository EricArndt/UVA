import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int field = 1;
        
        while (true) {
            int len = s.nextInt();
            int wid = s.nextInt();
            
            if (len == 0 && wid == 0) {
                break;
            }
            else if (field != 1) {
                System.out.println();
            }
            
            char[][] board = new char[len + 2][wid + 2];
            
            for (int i = 0; i < len; ++i) {
                String str = s.next();
                
                for (int j = 0; j < wid; ++j) {
                    board[i + 1][j + 1] = str.charAt(j);
                }
            }
            
            for (int i = 1; i < len + 1; ++i) {
                for (int j = 1; j < wid + 1; ++j) {
                    if (board[i][j] == '*') {
                        continue;
                    }
                    
                    int mines = 0;
                    
                    if (board[i + 1][j] == '*') {
                        ++mines;
                    }
                    if (board[i - 1][j] == '*') {
                        ++mines;
                    }
                    if (board[i][j + 1] == '*') {
                        ++mines;
                    }
                    if (board[i][j - 1] == '*') {
                        ++mines;
                    }
                    if (board[i + 1][j + 1] == '*') {
                        ++mines;
                    }
                    if (board[i + 1][j - 1] == '*') {
                        ++mines;
                    }
                    if (board[i - 1][j + 1] == '*') {
                        ++mines;
                    }
                    if (board[i - 1][j - 1] == '*') {
                        ++mines;
                    }
                    
                    board[i][j] = ("" + mines).charAt(0);
                }
            }
            
            System.out.printf("Field #%d:\n", field);
            
            for (int i = 1; i < len + 1; ++i) {
                for (int j = 1; j < wid + 1; ++j) {
                    System.out.print(board[i][j]);
                }
                    System.out.println();   
            }
            
            ++field;
        }
    }
}