Method 1:
public class Solution
{
    public char findTheDifference(String s, String t)
    {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        
        for(int i = 0; i < t.length(); i++)
        {
            char m = t.charAt(i);
            if(!map.containsKey(m) || map.get(m) == 0)
                return m;
            map.put(m, map.get(m) - 1);
        }
        
        return '\0';
    }
}

Method 2
public class Solution
{
    public char findTheDifference(String s, String t)
    {
        char c = 0;
        for(int i = 0; i < s.length(); i++)
            c ^= s.charAt(i);
        
        for(int j = 0; j < t.length(); j++)
            c ^= t.charAt(j);
        
        return c;
    }
}
