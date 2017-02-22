//My Solution:
public class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();
        
        while(true) {
            int sum = 0;
            while(n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            
            if(sum == 1)
                return true;
            
            if(set.contains(sum))
                return false;
            else {
                set.add(sum);
                n = sum;
            }
                
        }
    }
}
