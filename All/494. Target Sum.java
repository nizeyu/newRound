public class Solution
{
    int result = 0;
    public int findTargetSumWays(int[] nums, int S)
    {
        if(nums == null || nums.length == 0)
            return result;
        
        dfs(nums, S, 0, 0);
        return result;
    }
    
    private void dfs(int[] nums, int S, int pos, int temp)
    {
        if(pos == nums.length)
        {
            if(temp == S)
                result++;
            return;
        }
        dfs(nums, S, pos + 1, temp + nums[pos]);
        dfs(nums, S, pos + 1, temp - nums[pos]);
    }
}
