//Method 1
public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        
        Arrays.sort(nums);
        
        for(int i = 2; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = temp;
        }
    }
}

//Method 2
public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        
        for(int i = 1; i < nums.length; i ++) {
            if((i % 2 == 1 && nums[i] < nums[i-1]) || (i % 2 == 0 && nums[i] > nums[i-1])) {
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
        }
    }
}
