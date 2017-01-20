public class Solution
{
    private int[] nums;
    private static Random r = new Random();
    public Solution(int[] nums)
    {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset()
    {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    //FischerYatesInPlace shuffling
    public int[] shuffle()
    {
        int[] n = nums.clone();
        
        for(int i = nums.length-1; i >= 0; i--)
        {
            int pick = r.nextInt(i+1);
            int temp = n[pick];
            n[pick] = n[i];
            n[i] = temp;
        }
        return n;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
