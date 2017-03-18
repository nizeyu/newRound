//My Solution
public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {click[0], click[1]});
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; ++i) {
                int[] t = q.poll();
                int count = 0;
                if(board[t[0]][t[1]] == 'E') {
                    if(t[0] > 0 && board[t[0]-1][t[1]] == 'M') 
                        count++;
                    if(t[1] > 0 && board[t[0]][t[1]-1] == 'M') 
                        count++;
                    if(t[0] < board.length - 1 && board[t[0]+1][t[1]] == 'M') 
                        count++;
                    if(t[1] < board[0].length - 1 && board[t[0]][t[1]+1] == 'M') 
                        count++;
                    if(t[0] > 0 && t[1] > 0 && board[t[0]-1][t[1]-1] == 'M')
                        count++;
                    if(t[0] < board.length - 1 && t[1] < board[0].length - 1 && board[t[0]+1][t[1]+1] == 'M')
                        count++;
                    if(t[0] > 0 && t[1] < board[0].length - 1 && board[t[0]-1][t[1]+1] == 'M')
                        count++;
                    if(t[0] < board.length - 1 && t[1] > 0 && board[t[0]+1][t[1]-1] == 'M')
                        count++;
                        
                    if(count > 0) {
                        board[t[0]][t[1]] = (char)(count + 48);
                    } else {
                        board[t[0]][t[1]] = 'B';
                        
                        if(t[0] > 0 && board[t[0]-1][t[1]] == 'E')
                            q.offer(new int[] {t[0] - 1, t[1]});
                        
                        if(t[1] > 0 && board[t[0]][t[1]-1] == 'E')
                            q.offer(new int[] {t[0], t[1] - 1});
                        
                        if(t[0] < board.length - 1 && board[t[0]+1][t[1]] == 'E')
                            q.offer(new int[] {t[0] + 1, t[1]});
                        
                        if(t[1] < board[0].length - 1 && board[t[0]][t[1]+1] == 'E')
                            q.offer(new int[] {t[0], t[1] + 1});
                        
                        if(t[0] > 0 && t[1] > 0 && board[t[0]-1][t[1]-1] == 'E')
                            q.offer(new int[] {t[0] - 1, t[1] - 1});
                        
                        if(t[0] < board.length - 1 && t[1] < board[0].length - 1 && board[t[0]+1][t[1]+1] == 'E')
                            q.offer(new int[] {t[0] + 1, t[1] + 1});
                        
                        if(t[0] > 0 && t[1] < board[0].length - 1 && board[t[0]-1][t[1]+1] == 'E')
                            q.offer(new int[] {t[0] - 1, t[1] + 1});
                        
                        if(t[0] < board.length - 1 && t[1] > 0 && board[t[0]+1][t[1]-1] == 'E')
                            q.offer(new int[] {t[0] + 1, t[1] - 1});
                    }
                }
            }
        }
        return board;
    }
}
