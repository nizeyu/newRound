public class Solution
{
    public List<List<String>> solveNQueens(int n)
    {
        List<List<String>> result = new ArrayList<>();
        
        if(n <= 0)
            return result;
        
        int[] col = new int[n];
        
        solveNQueens(n, 0, col, result);
        
        return result;
    }
    
    private void solveNQueens(int n, int row, int[] col, List<List<String>> result)
    {
        if(row == n)
        {
            List<String> t = new ArrayList<>();
            
            for(int i = 0;i < n;i++)
            {
                StringBuilder sb = new StringBuilder();
                
                for(int j = 0;j < n;j++)
                {
                    if(col[i] == j)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                
                t.add(sb.toString());
            }
            result.add(new ArrayList<String>(t));
        }
        else
        {
            for(int i = 0;i < n;i++)
            {
                col[row] = i;
                
                if(isValid(row, col))
                    solveNQueens(n, row + 1, col, result);
            }
        }
    }
    
    private boolean isValid(int row, int [] col)
    {
        for(int i = 0;i < row;i++)
            if(col[row] == col[i] || Math.abs(col[row] - col[i]) == row - i)
                return false;
            
        return true;
    }
}
