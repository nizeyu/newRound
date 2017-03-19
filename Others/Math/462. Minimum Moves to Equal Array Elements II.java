//My Solution: 中位数
public class Solution {
    public int minMoves2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        
        int mid = 0;
        if(nums.length % 2 == 1)
            mid = nums[nums.length/2];
        else
            mid = (nums[nums.length/2 - 1] + nums[nums.length/2]) / 2;
        
        int res = 0;
        for(int i = 0; i < nums.length; ++i)
            res += Math.abs(nums[i] - mid);
        
        return res;
    }
}


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
