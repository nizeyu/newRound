public class Solution
{
    public void rotate(int[] nums, int k)
    {
        if(nums == null || nums.length < 2)
            return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        
    }
    
    private void reverse(int[] nums, int start, int end)
    {
        if(start > end || start < 0 || end > nums.length - 1)
            return;
        
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
