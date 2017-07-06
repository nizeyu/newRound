public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            pre[i] = -1;
        }
        
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                    
                }
            }
        }
        
        int maxIndex = 0;
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        
        int k = maxIndex;
        while (pre[k] != -1) {
            result.add(nums[k]);
            k = pre[k];
        }
        result.add(nums[k]);
        
        return result;
    }
}
