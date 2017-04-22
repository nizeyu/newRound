public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null || s.length() == 0 || p.length() == 0)
            return res;
        
        int[] hash = new int[256];
        for(char c : p.toCharArray())
            hash[c]++;
        
        int l = 0;
        int r = 0;
        int count = p.length();
        while(r < s.length()) {
            if(hash[s.charAt(r)] >= 1)
                count--;
            hash[s.charAt(r)]--;
            r++;
            
            if(count == 0)
                res.add(l);
            
            if(r - l == p.length()) {
                if(hash[s.charAt(l)] >= 0)
                    count++;
                hash[s.charAt(l)]++;
                l++;
            }
        }
        
        return res;
    }
}

//My solution
public class Solution
{
    public List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0)
            return result;
        if(p.length() > s.length())
            return result;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++)
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        
        int match = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c))
            {
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0)
                    match++;
            }
            if(i >= p.length())
            {
                c = s.charAt(i - p.length());
                if(map.containsKey(c))
                {
                    map.put(c, map.get(c) + 1);
                    if(map.get(c) >= 1)
                        match--;
                }
            }
            if(match == p.length())
                result.add(i - p.length() + 1);
        }
        return result;
    }
}
