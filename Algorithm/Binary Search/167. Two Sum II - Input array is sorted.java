// Self: lowerBound
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int index = lowerBound(numbers, i + 1, target - numbers[i]);
            if (index < numbers.length && numbers[index] == target - numbers[i]) {
                return new int[]{i+1, index+1};
            }
        }
        
        return new int[]{-1, -1};
    }
    
    private int lowerBound(int[] nums, int left, int target) {
        int l = left;
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
