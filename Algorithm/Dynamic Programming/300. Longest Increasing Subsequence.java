// DP
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        for (int i = 1; i < dp.length; i++) {
            int max = 1;
            boolean flag = false;
            for(int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(dp[j], max);
                    flag = true;
                }
            }
            
            if (flag) {
                dp[i] = max + 1;
            } else {
                dp[i] = 1;
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

// Brute Force : 2 ^ n * n
public class Solution {
    int max = 1;
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        backtracking(0, new ArrayList<Integer>(), nums);
        
        return max;
    }
    
    private void backtracking(int startIndex, List<Integer> subset, int[] nums) {
        if (isIncreasing(subset)) {
            int size = subset.size();
            max = Math.max(max, size);
        }
        
        for (int i =  startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            backtracking(i+1, subset, nums);
            subset.remove(subset.size() - 1);
        }
    }
    
    private boolean isIncreasing(List<Integer> subset) {
        if (subset == null || subset.size() == 0) {
            return false;
        }
        
        for (int i = 1; i < subset.size(); i++) {
            if (subset.get(i) <= subset.get(i-1)) {
                return false;
            }
        }
        
        return true;
    }
}
