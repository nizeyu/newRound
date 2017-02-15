public class Solution
{
    public boolean isAnagram(String s, String t)
    {
        Map<Character, Integer> map = new HashMap<>();
        
        if(s.length() != t.length())
            return false;
        
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
            if(!map.containsKey(m))
                return false;
            else if(map.get(m) <= 0)
                return false;
            
            map.put(m, map.get(m) - 1);
        }
        
        return true;
    }
}
