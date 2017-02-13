public class Solution
{
    private int r;
    private int c;
    private int [][] dp;
    
    public int longestIncreasingPath(int[][] matrix)
    {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        r = matrix.length;
        c = matrix[0].length;
        
        dp = new int[r][c];
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                max = Math.max(max, dfs(matrix, Integer.MIN_VALUE, 0, i, j));
        
        return max;
    }
    
    private int dfs(int[][] matrix, int head, int length, int i, int j)
    {
        if(i < 0 || i > r - 1 || j < 0 || j > c - 1 || matrix[i][j] <= head)
            return length;
        
        if(dp[i][j] > 0)
            return dp[i][j] + length;
        
        int temp = matrix[i][j];
        matrix[i][j] = Integer.MIN_VALUE;
        
        int l1 = dfs(matrix, temp, length+1, i+1, j);
        int l2 = dfs(matrix, temp, length+1, i-1, j);
        int l3= dfs(matrix, temp, length+1, i, j+1);
        int l4 = dfs(matrix, temp, length+1, i, j-1);
        
        matrix[i][j] = temp;
        
        dp[i][j] = Math.max(Math.max(l1, l2), Math.max(l3, l4)) - length;
        
        return dp[i][j] + length;
    }
}
