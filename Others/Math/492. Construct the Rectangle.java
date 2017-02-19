//Method: sqrt
public class Solution {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];//[L, W]
        if(area <= 0)
            return res;
            
        for(int i = (int)Math.sqrt(area); i > 0; i--) {//W
            if(area % i != 0)
                continue;
            int j = area / i;//L   
            res[0] = j;
            res[1] = i;
            break;
        }
        return res;
    }
}

//My Solution
public class Solution {
    public int[] constructRectangle(int area) {
        if(area <= 0)
            return new int[0];
        
        int[] res = new int[2];//[L, W]
        int min = Integer.MAX_VALUE;
        for(int i = area; i > 0; i--) {//L
            int j = area / i;
            if(i * j != area)
                continue;
                
            if(j > i)
                break;
            
            if(min > i - j) {
                min = Math.min(min, i - j);
                res[0] = i;
                res[1] = j;
            }
        }
        return res;
    }
}
