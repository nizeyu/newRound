//My Solution: hash table
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c) || map.get(c) <= 0)
                return false;
            else
                map.put(c, map.get(c) - 1);
        }
        return true;
    }
}

//My Solution: 人工hash
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < t.length(); i++) {
            if(map[t.charAt(i) - 'a'] <= 0)
                return false;
            else
                map[t.charAt(i) - 'a']--;
        }
        return true;
    }
}
