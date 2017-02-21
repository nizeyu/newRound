//My Solution
public class Solution
{
    public int firstUniqChar(String s)
    {
        if(s == null || s.length() == 0)
            return -1;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c))
                map.put(c, -1);
            else
                map.put(c, i);
        }
        
        int min = Integer.MAX_VALUE;
        for(int val : map.values())
        {
            System.out.println(val);
            if(val >= 0)
                min = Math.min(min, val);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

//My Solution: 人工hash
public class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0)
            return -1;
        
        int[] x = new int[26];
        int min = Integer.MAX_VALUE;
        
        for(int i  = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(x[index] > 0)
                x[index] = Integer.MAX_VALUE;
            else
                x[index] = i+1;
        }
        
        for(int i  = 0; i < 26; i++) {
            if(x[i] > 0)
                min = Math.min(min, x[i]);
        }
            
        if(min == Integer.MAX_VALUE)
            return -1;
            
        return min - 1;
    }
}

//discuss 简化
public class Solution {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
