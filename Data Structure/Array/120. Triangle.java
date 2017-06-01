//Method 1: DFS-Traverse
public class Solution {
    int min = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        dfs(0, 0, 0, triangle);
        return min;
    }
    
    //sum = root -> (x, y) 但不包含（x, y）的路径和
    private void dfs(int x, int y, int sum, List<List<Integer>> triangle) {
        if(x == triangle.size()) {
            min = Math.min(min, sum);
            return;
        }
        dfs(x+1, y, sum+triangle.get(x).get(y), triangle);
        dfs(x+1, y+1, sum+triangle.get(x).get(y), triangle);
    }
}

//Method 2: DFS-Divide Conquer
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        
        return divideConquer(0, 0, triangle);
    }
    //return minimum path from (x, y) to bottom
    private int divideConquer(int x, int y, List<List<Integer>> triangle) {
        if(x == triangle.size())
            return 0;
        
        return triangle.get(x).get(y) + Math.min(divideConquer(x+1, y, triangle), divideConquer(x+1, y+1, triangle));
    }
}


public class Solution
{
    public int minimumTotal(List<List<Integer>> triangle)
    {
        if(triangle.size() == 1)
            return triangle.get(0).get(0);
        
        int size = triangle.size();
        
        int [] dp = new int[size];
        
        for(int i = 0; i < triangle.get(size-1).size(); i++)
            dp[i] = triangle.get(size-1).get(i);
        
        for(int i = size-2; i >=0; i--)
            for(int j = 0; j < triangle.get(i).size(); j++)
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
        
        return dp[0];
    }
}
