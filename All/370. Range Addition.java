public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        if(length <= 0)
            return new int[0];
        
        int[] res = new int[length];
        for(int[] update : updates) {
            res[update[0]] += update[2];
            
            if(update[1] < length - 1)
                res[update[1] + 1] -= update[2];
        }
        
        int sum = 0;
        for(int i = 0; i < length; ++i) {
            sum += res[i];
            res[i] = sum;
        }
        
        return res;
    }
}

//My Solution
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        if(length <= 0)
            return new int[0];
        
        int[] res = new int[length];
        for(int[] update : updates) {
            for(int i = update[0]; i <= update[1]; ++i) {
                res[i] += update[2];
            }
        }
        return res;
    }
}
