//My Solution
public class Solution {
    public boolean checkRecord(String s) {
        if(s == null || s.length() == 0)
            return true;
        
        boolean A = false;
        int L = 0;
        for(int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'A';
            if(index == 0) {
                if(A == true)
                    return false;
                else {
                    L = 0;
                    A = true;
                }
            }else if(index == 11) {
                L++;
                if(L > 2)
                    return false;
            } else {
                L = 0;
            }
        }
        return true;
    }
}
