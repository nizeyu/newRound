public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        
        int[] dp = new int[len+1];
        dp[0] = 1;
        int preNum = getNum(0, s);
        dp[1] = preNum == 0 ? 0 : 1;
        
        for (int i = 2; i < len+1; i++) {
            int count = 0;
            int curNum = getNum(i-1, s);
            if (curNum != 0) {
                count += dp[i-1];
            }
            
            if (preNum != 0 && preNum * 10 + curNum <= 26) {
                count += dp[i-2];
            }
            
            dp[i] = count;
            
            preNum = curNum;
        }
        
        return dp[len];
    }
    
    private int getNum(int i, String s) {
        char a = s.charAt(i);
        return Character.getNumericValue(a);
    }
}
