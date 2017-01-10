public class Solution
{
    public boolean wordPattern(String pattern, String str)
    {
        Map<Character, String> map = new HashMap<>();
        String[] s = str.split(" ");
        
        if(pattern.length() != s.length)
            return false;
        
        for(int i = 0; i < s.length; i++)
        {
            char c = pattern.charAt(i);
            if(map.containsKey(c))
            {
                if(!map.get(c).equals(s[i]))
                    return false;
            }
            else if(map.containsValue(s[i]))
                return false;
            map.put(c, s[i]);
        }
        return true;
    }
}
