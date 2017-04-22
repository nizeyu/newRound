//My Solution
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[0];
        
        int[] output = new int[nums.length];
        
        int pre = nums[0];
        output[0] = 1;
        for(int i = 1; i < nums.length; i++) {
           output[i] = pre;
           pre *= nums[i];
        }
        
        int post = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
           output[i] *= post;
           post *= nums[i];
        }
        
        return output;
    }
}

//Discuss
public class Solution
{
    public int[] productExceptSelf(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return new int[0];
        
        int[] output = new int[nums.length];
        output[0] = 1;
        
        for(int i = 1; i < nums.length; i++)
            output[i] = output[i-1] * nums[i-1];
        
        int right = 1; 
        for(int i = nums.length-1; i >= 0; i--)
        {
            output[i] *= right;
            right *= nums[i];
        }
        
        return output;
    }
}
