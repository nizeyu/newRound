public class Solution
{
    public List<Integer> grayCode(int n)
    {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if(n == 0)
            return result;
        if(n == 1)
        {
            result.add(1);
            return result;
        }
        
        int prefix = 1 << (n-1);
        result = grayCode(n-1);
        for(int i = result.size() - 1; i >= 0; i--)
            result.add(prefix + result.get(i));
        
        return result;
    }
}
