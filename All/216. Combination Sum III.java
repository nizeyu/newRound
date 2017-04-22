public class Solution
{
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> result = new ArrayList<>();
        
        combinationSum3(k, n, 1, new ArrayList<>(), result);
        return result;
    }
    
    private void combinationSum3(int k, int n, int start, List<Integer> tempList, List<List<Integer>> result)
    {
        if(n < 0)
            return;
        else if(tempList.size() == k && n == 0)
            result.add(new ArrayList<>(tempList));
        else
        {
            for(int i = start; i <= 9; i++)
            {
                tempList.add(i);
                combinationSum3(k, n-i, i+1, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
