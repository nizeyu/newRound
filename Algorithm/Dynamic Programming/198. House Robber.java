// brute force
public class Solution {
    int max = Integer.MIN_VALUE;
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        dfs(0, 0, nums);
        
        return max;
    }
    
    private void dfs(int i, int sum, int[] nums) {
        if (i >= nums.length) {
            max = Math.max(max, sum);
            return;
        }
        
        sum += nums[i];
        dfs(i+2, sum, nums);
        sum -= nums[i];
        
        dfs(i+1, sum, nums);
    }
}

// improve
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] t = new int[nums.length];
        int[] f = new int[nums.length];
        t[0] = nums[0];
        f[0] = 0;
        
        for (int i = 1; i < nums.length; i++) {
            t[i] = nums[i] + f[i-1];
            f[i] = Math.max(t[i-1], f[i-1]);
        }
        
        return Math.max(t[nums.length-1], f[nums.length-1]);
    }
}

//My Solution
public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int dp[] = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i < dp.length; i++)
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        
        return dp[dp.length - 1];
    }
}
