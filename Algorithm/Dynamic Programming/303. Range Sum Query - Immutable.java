Method 1: Time Limit Exceeded
public class NumArray
{
    int[] n;
    public NumArray(int[] nums)
    {
         n = new int[nums.length];
         for(int i = 0; i < nums.length; i++)
            n[i] = nums[i];
    }
    
    public int sumRange(int i, int j)
    {
        int sum = 0;
        for(int k = i; k <= j; k++)
            sum += n[k];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
 
 Method 2:
 public class NumArray
{
    int[] dp;
    public NumArray(int[] nums)
    {
         dp = new int[nums.length + 1];
         dp[0] = 0;
         for(int i = 1; i < dp.length; i++)
            dp[i] = dp[i-1] + nums[i-1];
    }
    
    public int sumRange(int i, int j)
    {
        if(i > j || i < 0 || j + 1 > dp.length)
            return 0;
        return dp[j+1] - dp[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
