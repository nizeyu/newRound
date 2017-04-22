//My Solution
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0)
            return res;
        
        backtracking(new ArrayList<>(), new boolean[nums.length], nums);
        
        return res;
    }
    
    private void backtracking(List<Integer> temp, boolean[] used, int[] nums) {
        if(temp.size() == nums.length)
            res.add(new ArrayList<>(temp));
        else {
            for(int i = 0; i < nums.length; ++i) {
                if(used[i] == false) {
                    temp.add(nums[i]);
                    used[i] = true;
                    backtracking(temp, used, nums);
                    used[i] = false;
                    temp.remove(temp.size()-1);
                }
            } 
        }
    }
}

//Discuss
public class Solution
{
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        dfs(nums, new ArrayList<>(), result);
        
        return result;
    }
    
    private void dfs(int[] nums, List<Integer> permutation, List<List<Integer>> result)
    {
        if(permutation.size() == nums.length)
            result.add(new ArrayList(permutation));
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(permutation.contains(nums[i]))
                    continue;
                permutation.add(nums[i]);
                dfs(nums, permutation, result);
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
