public class Solution
{
    public int[] intersection(int[] nums1, int[] nums2)
    {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int [0];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums1.length; i++)
        {
            if(i == 0 || nums1[i] > nums1[i - 1])
            {
                if(Arrays.binarySearch(nums2, nums1[i]) > -1)
                    list.add(nums1[i]);
            }
        }
        
        int [] result = new int [list.size()];
        
        int i = 0;
        
        for(int x: list)
            result[i++] = x;
        
        return result;
    }
}
