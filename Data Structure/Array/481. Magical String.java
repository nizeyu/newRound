public class Solution
{
    public int magicalString(int n)
    {
        if(n == 0)
            return 0;
        else if(n <= 3) return 1;
        
        int[] num = new int[n];
        int result = 1;
        num[0] = 1;
        num[1] = 2;
        boolean one = false;
        int index = 1;
        for(int i = 1; i < n; i++)
        {
            for(int j = num[index]; j > 0; j--)
            {
                if(i >= n) break;
                num[i] = one ? 1 : 2;
                if(one) result++;
                i++;
            }
            i--;
            one = !one;
            index++;
        }
        return result;
    }
}
