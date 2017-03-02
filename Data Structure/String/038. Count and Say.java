//My Solution
public class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        
        String strs = countAndSay(n - 1) + "*";
        String res = "";
        int count = 1;
        
        for(int i = 0; i < strs.length() - 1; i++) {
            if(strs.charAt(i) != strs.charAt(i+1)) {
                res = res + count + strs.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        return res;
    }
}
