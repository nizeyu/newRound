//My Solution
public class Solution {
    public boolean isUgly(int num) {
        if(num < 1)
            return false;

        while(num != 1) {
            if(num % 2 == 0)
                num /= 2;
            else if(num % 3 == 0)
                num /= 3;
            else if(num % 5 == 0)
                num /= 5;
            else
                return false;
        }
        return true;
    }
}

public class Solution
{
    public boolean isUgly(int num)
    {
        if(num < 1)
            return false;
        
        while(num % 2 == 0)
            num /= 2;
        
        while(num % 3 == 0)
            num /= 3;
        
        while(num % 5 == 0)
            num /= 5;
        
        return num == 1;
    }
}
