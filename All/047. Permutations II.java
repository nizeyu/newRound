public class Solution
{
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);    
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int[] nums, boolean[] used, List<Integer> permutation, List<List<Integer>> result)
    {
        if(permutation.size() == nums.length)
            result.add(new ArrayList(permutation));
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1])
                    continue;
                used[i] = true; 
                permutation.add(nums[i]);
                dfs(nums, used, permutation, result);
                used[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
