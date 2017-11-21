// Self: lowerBound + upperBound
public class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = 1; i < nums.length; i++) { // search 1 ~ n
            int l = lowerBound(nums, i);
            if (l == nums.length || nums[l] != i) {
                continue;
            }
            int r = upperBound(nums, i);
            if (r > 0 && r - 1 != l && nums[r-1] == nums[l]) {
                return i;
            }   
        }
        
        return -1;
    }
    
    private int lowerBound(int[] nums, int target) {
        int l = 0; 
        int r = nums.length;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            
            if (target <= nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private int upperBound(int[] nums, int target) {
        int l = 0; 
        int r = nums.length;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            
            if (target < nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
}

// Binary Search
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (mid + 1 <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; 
    }
}

