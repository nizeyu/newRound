public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0)
            return 0;
        
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; ++i) {
            for(int j = 0; j < points.length; ++j) {
                if(i == j)
                    continue;
                
                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            
            for(int d : map.values()) {
                res += d * (d - 1);
            }
            
            map.clear();
        }
        return res;
    }
    
    private int getDistance(int[] point1, int[] point2) {
        return (int)(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }
}

//Time complexity:  O(n^2)
//Space complexity: O(n)
