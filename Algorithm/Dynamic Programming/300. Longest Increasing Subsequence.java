// Brute Force
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
