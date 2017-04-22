//My Solution
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        
        int[] hash = new int[256];
        for(int i = 0; i < s.length(); i++)
            hash[s.charAt(i)]++;
        
        boolean flag = false;
        for(int i = 0; i < 256; i++) {
            if(flag == true && hash[i] % 2 == 1)
                return false;
                
            if(hash[i] % 2 == 1)
                flag = true;
        }
        return true;
    }
}
