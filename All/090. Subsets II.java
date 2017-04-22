public class Solution
{
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
            
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtracking(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result)
    {
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++)
        {
            if(i > start && nums[i] == nums[i-1])
                continue;
            tempList.add(nums[i]);
            backtracking(nums, i+1, tempList, result);
            tempList.remove(tempList.size()-1);
        }
    }
}
