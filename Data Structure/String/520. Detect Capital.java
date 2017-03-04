public class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            if('Z' - word.charAt(i) >= 0)
                count++;
        }
        
        return count == 0 || count == word.length() || (count == 1 && 'Z' - word.charAt(0) >= 0);
    }
}
