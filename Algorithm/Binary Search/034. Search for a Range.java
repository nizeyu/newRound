// Self: lowerBound + upperBound
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        int l = lowerBound(nums, target);
        int r = upperBound(nums, target);
        
        if (l >= nums.length || nums[l] != target) { // 检查上边界 和 值是否相等
            return new int[]{-1, -1};
        }
        
        return new int[]{l, r-1};
    }
    
    private int lowerBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        } 

        return l;
    }

    private int upperBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (target < nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
