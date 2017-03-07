//My Solution
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0)
            return res;
        
        char[] str = s.toCharArray();
        for(int i = 1; i < str.length; i++) {
            if(str[i] == '+' && str[i-1] == '+') {
                str[i] = '-';
                str[i-1] = '-';
                res.add(String.valueOf(str));
                str[i] = '+';
                str[i-1] = '+';
            }
        }
        return res;
    }
}
