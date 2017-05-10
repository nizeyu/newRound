public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;//分别计算nums的行和列的大小
        int col = nums[0].length;
        if(r * c != row * col)//如果row*col和要求的r*c的大小不一样
            return nums;//返回原来的vector nums
        
        int[][] res = new int[r][c];//初始化vector为r行c列
        
        // for(int i = 0; i < r; ++i)
        //     for(int j = 0; j < c; ++j)//将原来的值赋给新的res，注意索引
        //         res[i][j] = nums[(i * c + j) / col][(i * c + j) % col];
        
        //上面代码可以用下面代替，都是一个道理
        for(int i = 0; i < r * c; ++i)
            res[i/c][i%c] = nums[i/col][i%col];
        
        return res;
    }
}
