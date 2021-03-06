public class Solution
{
    Queue<Integer> q = new LinkedList<>();
    
    public void solve(char[][] board)
    {
        if(board == null || board.length == 0)
            return;
        
        int r = board.length;
        int c = board[0].length;
        
        for(int i = 0; i < r; i++)
        {
            if(board[i][0] == 'O')
                solve(board, i, 0);
            
            if(board[i][c - 1] == 'O')
                solve(board, i, c - 1);
        }
        
        for(int j = 0; j < c; j++)
        {
            if(board[0][j] == 'O')
                solve(board, 0, j);
                
            if(board[r - 1][j] == 'O')
                solve(board, r - 1, j);
        }
        
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                    
                if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    
    private void solve(char [][] board, int i, int j)
    {
        if(board == null || board.length == 0)
            return;
        
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
            return;
        
        fill(board, i, j);
        
        int c = board[0].length;
        
        while(!q.isEmpty())
        {
            int cur = q.poll();
            int x = cur / c;
            int y = cur % c;
            
            fill(board, x - 1, y);
            fill(board, x + 1, y);
            fill(board, x, y - 1);
            fill(board, x, y + 1);
        }
    }
    
    private void fill(char [][] board, int i, int j)
    {
        if(board == null || board.length == 0)
            return;
        
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'O')
            return;
        
        q.offer(i * board[0].length + j);
        
        board[i][j] = '#';
    }
}
