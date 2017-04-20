//Method 1
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] res = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};
        
        for(int i = 0; i < m * n; ++i) {
            res[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];
            
            if(row >= m) { row = m - 1; col += 2; d = 1 - d; }
            if(col >= n) { col = n - 1; row += 2; d = 1 - d; }
            if(row < 0) { row = 0; d = 1 - d; }
            if(col < 0) { col = 0; d = 1 - d; }
        }
        return res;
    }
}

//Method 2
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new int[0];
        boolean up = true;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] res = new int[m * n];
        int row = 0, col = 0;
        
        for(int i = 0; i < m * n; ++i) {
            res[i] = matrix[row][col];
            
        if(up) {
                if((row-1) >= 0 && (col+1) < matrix[0].length) {
                    row--;
                    col++;
                } else if((col+1) < matrix[0].length) {
                    col++;
                    up = false;
                } else if((row+1) < matrix.length){
                    row++;
                    up = false;
                } else {
                    break;
                }
            } else {//down
                if((row+1) < matrix.length && (col-1) >= 0) {
                    row++;
                    col--;
                } else if((row+1) < matrix.length) {
                    row++;
                    up = true;
                } else if((col+1) < matrix[0].length) {
                    col++;
                    up = true;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
