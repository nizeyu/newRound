// O(n)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int l = 0;
        int r = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        while (r < nums.length) {
            sum += nums[r];
            r++;
            
            while (sum >= s) {
                min = Math.min(min, r-l);
                sum -= nums[l];
                l++;
            } 
        }
        
        return min == Integer.MAX_VALUE ? 0 : min; 
    }
}

// O(nlog n)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] sums = new int[nums.length + 1];
        
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        
        int minLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < sums.length; i++) {
            int end = lowerbound(i+1, sums.length, sums[i]+s, sums);
            if (end == sums.length) {
                break;
            }
            if (end - i < minLen) {
                minLen = end - i;
            } 
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen; 
    }
    
    private int lowerbound(int l, int r, int target, int[] sums) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (target <= sums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    } 
}
