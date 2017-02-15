public class Solution
{
    public int longestPalindrome(String s)
    {
        if(s == null || s.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int pairs = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(set.contains(c))
            {
                pairs++;
                set.remove(c);
            }
            else
               set.add(c); 
        }
        
        if(!set.isEmpty())
            return pairs * 2 + 1;
        
        return pairs * 2;
    }
}
