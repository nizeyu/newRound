public class Solution
{
    public boolean isHappy(int n)
    {
        if(n < 1)
            return false;
        
        HashSet<Integer> set = new HashSet<>();
            
        while(!set.contains(n))
        {
            set.add(n);
            int happy = 0;
            while(n > 0)
            {
                happy += (n % 10) * (n % 10); 
                n /= 10;
            }
            
            if(happy == 1)
                return true;
            else
                n = happy;
        }
        
        return false;
    }
}
