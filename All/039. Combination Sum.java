public class Solution
{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0)
            return result;
            
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void combinationSum(int[] candidates, int target, int start, List<Integer> tempList, List<List<Integer>> result)
    {
        if(target < 0)
            return;
        else if(target == 0)
            result.add(new ArrayList<>(tempList));
        else
        {
            for(int i = start; i < candidates.length; i++)
            {
                tempList.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i, tempList, result);
                // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
