//My Solution: 人工hash
public class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        int[] map = new int[256];
        for(int i = 0; i < s.length(); ++i)
            map[s.charAt(i)]++;
        
        int res = 0;
        boolean flag = false;//for odd element exit 
        for(int i = 0; i < 256; ++i) {
            if(map[i] == 1)
                flag = true;
                
            if(map[i] > 1) {
                if(map[i] % 2 == 0)
                    res += map[i];
                else {
                    res += map[i] - 1;
                    flag = true;
                }
            }
        }
        if(flag)
            return res + 1;
        else
            return res;
    }
}

//HashSet
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
