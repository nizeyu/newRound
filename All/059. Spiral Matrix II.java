public class Solution
{
    public int[][] generateMatrix(int n)
    {
        if(n < 1)
            return new int[0][0];
        
        int[][] matrix = new int[n][n];
        
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int num = 1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd)
        {
            for(int j = colBegin; j <= colEnd; j++)
                matrix[rowBegin][j] = num++;
            rowBegin++;
            
            for(int j = rowBegin; j <= rowEnd; j++)
                matrix[j][colEnd] = num++;
            colEnd--;
            
            if(rowBegin <= rowEnd)
            {
                for(int j = colEnd; j >= colBegin; j--)
                    matrix[rowEnd][j] = num++;
            }
            rowEnd--;
            
            if(colBegin <= colEnd)
            {
                for(int j = rowEnd; j >= rowBegin; j--)
                    matrix[j][colBegin] = num++;
            }
            colBegin++;
        }
        return matrix;
    }
}
