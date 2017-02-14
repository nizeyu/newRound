public class Solution
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0 || nums == null)
            return result;
            
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtracking(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result)
    {
        result.add(new ArrayList<Integer>(tempList));
        
        for(int i = start; i < nums.length; i++)
        {
            tempList.add(nums[i]);
            backtracking(nums, i+1, tempList, result);
            tempList.remove(tempList.size()-1);
        }
    }
}
