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

思路：

我们可以跟随例子中的路线来遍历矩阵，路线无非就是从左下到右上，到顶后又从右上到坐下，一直到最右下角一个点。

在往右上的过程中，一般是行在减，列在加，有三种情况停止右上：

到了第一行，不能再往上了；
到了最右边列，不能再往右了；
到了最右下角的元素，这时候要全部结束遍历。
往左下的过程中，一般是行在加，列在减，有三种情况停止左下：

到了第一列，不能在往左了；
到了最下边的行，不能再往下了；
到了最右下角的元素，这时候要全部结束遍历。
我们把这个过程用代码实现出来就可以了，用多个 if - else 来分支处理。

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
