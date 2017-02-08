public class Solution
{
    public List<Integer> lexicalOrder(int n)
    {
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < 10; i++)
            dfs(i, n, result);
        
        return result;
    }
    
    private void dfs(int cur, int n, List<Integer> result)
    {
        if(cur > n)
            return;
        else
        {
            result.add(cur);
            for(int i = 0; i < 10; i++)
            {
                if(10 * cur + i > n)
                    return;
                dfs(10 * cur + i, n, result);
            }
        }
    }
}
