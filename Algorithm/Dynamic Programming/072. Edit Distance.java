public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (same(i-1, j-1, word1, word2)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
    }
    
    private boolean same(int i, int j, String word1, String word2) {
        return word1.charAt(i) == word2.charAt(j);
    }
}

/* 编辑距离，即给了字符串T1和字符串T2，试问通过插入、删除、替换等的操作，T1可以通过几步变换成T2？

这道题首先还是动态规划解决，构建n*m矩阵，位置[i,j]标示串T1[0,i]和T2[0,j]的编辑距离。

显而易见的是，对于矩阵中的i,j位置，他可以有如下三种方式变换： 
1、从i-1,j 为T1增加一个字符，获得i，j，这样编辑距离本身就需要+1 
2、同理，从i，j-1过来，编辑距离必须+1。 
3、从i-1，j-1位置变换过来，那么这个时后，如果T1在i的取值和T2在j的取值一样，那么这个变换，编辑距离不变，如果不一样，那么就需要做替换操作，那么必须+1.

如上我们就看到了每一个子问题的求解方式，那么对于答案： 
1、首先构造边界的值，如i=0，j=0的时候，编辑距离就是和已匹配的长度一样，因为全都要做插入 
2、按照顺序遍历 
3、输出最终位置的答案。*/

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (same(i-1, j-1, word1, word2)) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                }
            }
        }
        
        return dp[m][n];
    }
    
    private boolean same(int i, int j, String word1, String word2) {
        return word1.charAt(i) == word2.charAt(j);
    }
}
