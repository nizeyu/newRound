//My Soluiton
public class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if(x < 0)
            flag = true;
        x = Math.abs(x);
        
        long res = 0;
        while(x > 0) {
            res = res * 10 + x % 10;
            if(res > Integer.MAX_VALUE)
                return 0;
            x /= 10;
        }
        if(flag)
            return -(int)res;
        else
            return (int)res;
    }
}


public class Solution
{
    public int reverse(int x)
    {
        int result = 0;
        
        while(x != 0)
        {
            if(Math.abs(result) > Integer.MAX_VALUE / 10)
                return 0;
            result = result * 10 + x % 10;
            x /= 10;
        }
        
        return result;
    }
}
