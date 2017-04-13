public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0)
            return new int[0];
        
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        
        
        if(a > 0) {
            int k = nums.length - 1;
            while(i <= j) {
                int m = a * nums[i] * nums[i] + b * nums[i] + c;
                int n = a * nums[j] * nums[j] + b * nums[j] + c;
                
                if(m >= n) {
                    res[k--] = m;
                    i++;
                } else {
                    res[k--] = n;
                    j--;
                } 
            }
        } else {
            int k = 0;
            while(i <= j) {
                int m = a * nums[i] * nums[i] + b * nums[i] + c;
                int n = a * nums[j] * nums[j] + b * nums[j] + c;
                
                if(m <= n) {
                    res[k++] = m;
                    i++;
                } else {
                    res[k++] = n;
                    j--;
                } 
            }
        }
        
        return res;
    }
}
