// 最优解
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return result;
        }
        
        int[] hash = new int[256];
        for (int i = 0; i < p.length(); i++) {
            hash[p.charAt(i)]++; 
        }
        
        int start = 0;
        int end = 0;
        int count = 0;
        while (end < s.length() && s.length() - start >= p.length()) {
            if (hash[s.charAt(end)] >= 1) {
                count++;
            }
            
            hash[s.charAt(end)]--;
            
            if (count == p.length()) {
                result.add(start);
            }
            
            end++;
            
            if (end - start == p.length()) {
                hash[s.charAt(start)]++;
                
                if (hash[s.charAt(start)] >= 1) {
                    count--;
                }
                
                start++;   
            }   
        }
        
        return result;
    }
}

//My solution
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return result;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int l = 0;
        int r = 0;
        int count = p.length();
        while (r < s.length() && s.length() - l >= p.length()) {
            char right = s.charAt(r);
            if (map.containsKey(right)) {
                if (map.get(right) >= 1) {
                    count--;
                }
                map.put(right, map.get(right) - 1);
            }
            
            if (count == 0) {
                result.add(l);
            }
            
            r++;
            
            if (r - l == p.length()) {
                char left = s.charAt(l);
                if (map.containsKey(left)) {
                    if (map.get(left) >= 0) {
                        count++;
                    }
                    map.put(left, map.get(left) + 1);
                }
                
                l++;
            }   
        }
        
        return result;
    }
}
