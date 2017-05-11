//My Solution
public class Solution {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        
        return sum - min * nums.length;
    }
}

//逆向思维
public class Solution {
    public int minMoves(int[] nums) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++)
            min = Math.min(min, nums[i]);
        
        for(int i = 0; i < nums.length; i++)
            res += nums[i] - min;
            
        return res;
    }
}
