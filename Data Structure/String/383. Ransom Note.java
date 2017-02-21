//My Solution
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() == 0 && magazine.length() == 0)
            return true;
        else if(ransomNote.length() == 0)
            return true;
        else if(magazine.length() == 0)
            return false;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++)
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        
        for(int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if(!map.containsKey(c)) {
                return false;
            } else {
                if(map.get(c) <= 0)
                    return false;
                map.put(c, map.get(c) - 1);
            }
        }
        return true;   
    }
}

//My Solution:
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a'] += 1;
        }
        
        for(int i = 0; i < ransomNote.length(); i++) {
            if(arr[ransomNote.charAt(i) - 'a'] <= 0)
                return false;
            arr[ransomNote.charAt(i) - 'a'] -= 1;
        }
        return true;
    }
}
