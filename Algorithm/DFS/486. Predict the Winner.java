public class Solution
{
    public boolean PredictTheWinner(int[] nums)
    {
        return helper(nums, 0, nums.length - 1) >= 0;
    }
    
    private int helper(int[] nums, int s, int e)
    {
        if(s == e)
            return nums[e];
        else
        {
            int selectStart = nums[s] - helper(nums, s + 1, e); 
            int selectEnd = nums[e] - helper(nums, s, e - 1);
            return Math.max(selectStart, selectEnd);
        }
    }
}
