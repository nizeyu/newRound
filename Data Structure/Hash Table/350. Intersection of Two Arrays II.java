public class Solution
{
    public int[] intersect(int[] nums1, int[] nums2)
    {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int [0];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<>();
        
        int p = 0;
        int q = 0;
        
        while(p < nums1.length && q < nums2.length)
        {
            if(nums1[p] < nums2[q])
                p++;
            else if(nums1[p] > nums2[q])
                q++;
            else
            {
                list.add(nums1[p]);
                p++;
                q++;
            }
        }
        
        int [] result = new int [list.size()];
        int i = 0;
        
        for(int x: list)
            result[i++] = x;
        
        return result;
    }
}
