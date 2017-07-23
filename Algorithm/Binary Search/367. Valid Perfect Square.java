// Self: lowerBound
public class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1;
        int r = num;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            
            if (num == m * m) {
                return true;
            }
            
            if (num / m <= m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l * l == num;
    }
}
