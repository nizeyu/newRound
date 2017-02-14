public class Solution
{
    public int search(int[] nums, int target)
    {
        if(nums == null || nums.length == 0)
            return -1;
        
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r)
        {
            int m = l + (r - l) / 2;
            
            if(nums[m] == target)
                return m;
            
            if(nums[m] >= nums[l])
            {
                if(nums[m] > target && target >= nums[l])
                    r = m - 1;
                else
                    l = m + 1;
            }
            else
            {
                if(nums[m] < target && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            }
        }
        
        return -1;
    }
}
