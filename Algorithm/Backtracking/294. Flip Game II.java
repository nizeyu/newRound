public class Solution {
    public boolean canWin(String s) {
        List<String> list = new ArrayList<>();
        char[] str = s.toCharArray();
        for(int i = 1; i < str.length; ++i) {
            if(str[i] == '+' && str[i-1] == '+') {
                str[i] = '-';
                str[i-1] = '-';
                list.add(String.valueOf(str));
                str[i] = '+';
                str[i-1] = '+';
            }
        }
        
        for(String t : list) {
            if(!canWin(t))
                return true;
        }
        
        return false;
    }
}
