// lintcode: DP
public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int maxLength = getMaxLength(dict);
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for (int i = 1; i < dp.length; i++) {
            for (int lastWordLength = 1;
                     lastWordLength <= maxLength && lastWordLength <= i;
                     lastWordLength++) {
                if (!dp[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];  
    }
    
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}

// LeetCode: DP
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int maxLength = getMaxLength(wordDict);
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for (int i = 1; i < dp.length; i++) {
            for (int lastWordLength = 1;
                     lastWordLength <= maxLength && lastWordLength <= i;
                     lastWordLength++) {
                if (!dp[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (wordDict.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
    private int getMaxLength(List<String> wordDict) {
        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}

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
