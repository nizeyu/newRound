class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 == 1) {
            return false;
        }
        
        int target = sum / 2;
        
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        
        return dp[target];
    }
}
