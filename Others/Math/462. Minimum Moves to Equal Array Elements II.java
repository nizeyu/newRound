public class Solution
{
    public int minMoves2(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        while(i < j)
        {
            count += nums[j] - nums[i];
            j--;
            i++;
        }
        
        return count;
    }
}
