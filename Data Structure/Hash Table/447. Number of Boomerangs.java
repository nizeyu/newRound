public class Solution
{
    public int numberOfBoomerangs(int[][] points)
    {
        if(points == null || points.length == 0)
            return 0;
        
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++)
        {
            for(int j = 0; j < points.length; j++)
            {
                if(i == j)
                    continue;
                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            
            for(int val : map.values())
                result += val * (val - 1);
            
            map.clear();
        }
        return result;
    }
    
    private int getDistance(int[] x, int[] y)
    {
        int dx = x[0] - y[0];
        int dy = x[1] - y[1];
        return dx*dx + dy*dy;
    }
}
