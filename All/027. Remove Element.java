//My Solution
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int i = 0; 
        int j = nums.length - 1;
        while(i < j) {
            while(i < j && nums[i] != val)
                i++;
            
            while(i < j && nums[j] == val)
                j--;
                
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        if(nums[i] == val)
            return i;
        else
            return i + 1;
    }
}

//discuss
public class Solution
{
	public int removeElement(int [] nums, int val)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int i = 0;
		int j = 0;

		while(i < nums.length)
		{
			if(nums[i] != val)
				nums[j++] = nums[i];
			i++;
		}

		return j;
	}
}
