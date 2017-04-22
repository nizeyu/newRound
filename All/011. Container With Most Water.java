public class Solution
{
    public int maxArea(int[] height)
    {
        if(height == null || height.length == 0)
            return 0;
        
        int i = 0;
        int j = height.length - 1;
        int max = (j - i) * Math.min(height[i], height[j]);
        int area = 0;
        
        while(i < j)
        {
            if(height[i] < height[j])
            {
                int prev = height[i];
                while(height[i] <= prev && i < j)
                    i++;
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
            else
            {
                int prev = height[j];
                while(height[j] <= prev && i < j)
                    j--;
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }
}
