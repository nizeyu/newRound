public class Solution
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0)
            return result;
        
        Arrays.sort(candidates);
        backtracking(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    
    private void backtracking(int[] candidates, int start, int target, List<Integer> tempList, List<List<Integer>> result)
    {
        if(target < 0)
            return;
        else if(target == 0)
             result.add(new ArrayList<>(tempList));
        else
        {
            for(int i = start; i < candidates.length; i++)
            {
                if(i > start && candidates[i] == candidates[i-1])
                    continue;
                tempList.add(candidates[i]);
                backtracking(candidates, i + 1, target - candidates[i], tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
