//My Solution
public class Solution
{
    public boolean isPalindrome(int x)
    {
        if(x < 0)
            return false;
        
        int divider = 1;
        while(x / divider > 9)
            divider *= 10;
        
        while(x != 0)
        {
            int l = x / divider;
            int r = x % 10;
            if(l != r)
                return false;
            x = (x % divider) / 10;
            divider /= 100;
        }
        
        return true;
    }
}

//My Solution:照镜子
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        
        int n = x;
        int res = 0;
        while(n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        return res == x;
    }
}
