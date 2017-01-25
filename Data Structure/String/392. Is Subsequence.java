public class Solution
{
    public boolean isSubsequence(String s, String t)
    {
        if(s == null || t == null)
            return false;
        if(s.length() == 0)
            return true;
        if(t.length() == 0)
            return false;
        
        int j = 0;
        for(int i = 0; i < t.length(); i++)
        {
            char c = t.charAt(i);
            if(s.charAt(j) == c)
                j++;
            if(j == s.length())
                return true;
        }
        return false;
    }
}
