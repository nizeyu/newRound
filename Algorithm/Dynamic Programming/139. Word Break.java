// DP
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int len = s.length();
        
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        
        return dp[len];
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
