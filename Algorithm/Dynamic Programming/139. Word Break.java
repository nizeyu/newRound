




// brute force
public class Solution {
    boolean result = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        backtracking(0, s, wordDict);
        
        return result;
    }
    
    private void backtracking(int startIndex, String s, List<String> wordDict) {
        if (startIndex == s.length()) {
            result = true;
            return;
        }
        
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i+1);
            //System.out.println(sub);
            
            if (wordDict.contains(sub)) {
                backtracking(i+1, s, wordDict);
            }
        }
    }
}
