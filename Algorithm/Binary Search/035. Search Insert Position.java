//Self: lowerBound
public class Solution {
    public int searchInsert(int[] nums, int target) {
        return lowerbound(nums, target);
    }
    
    private int lowerbound(int[] nums, int target) {
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
}
