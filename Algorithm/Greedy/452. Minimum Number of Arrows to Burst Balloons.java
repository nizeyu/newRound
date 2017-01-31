public class Solution
{
    public int findMinArrowShots(int[][] points)
    {
        if(points == null || points.length == 0 || points[0].length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0])
                    return a[1] - b[1];
                else
                    return a[0] - b[0];
            }
        });
        
        int minArrows = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i++)
        {
            if(points[i][0] > end)
            {
                minArrows++;
                end = points[i][1];
            }
            else
            {
                end = Math.min(end, points[i][1]);
            }
        }
        return minArrows;
    }
}
