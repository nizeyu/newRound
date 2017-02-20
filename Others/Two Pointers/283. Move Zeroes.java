//tow pointer O(n)
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
            
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}


//My Solution
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        
        int i = 0;//pointer for 0
        int j = 0;//pointer for not 0
        while(i < nums.length && j < nums.length) {
            while(nums[i] != 0 && i < nums.length - 1)
                i++;
            
            while(nums[j] == 0 && j < nums.length - 1)
                j++;
            
            if(i < j) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            } else {
                j++;
            }
        }
    }
}
