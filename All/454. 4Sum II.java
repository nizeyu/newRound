public class Solution
{
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D)
    {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++)
        {
            for(int j = 0; j < B.length; j++)
            {
                map.put(C[i] + D[j], map.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        
        for(int i = 0; i < A.length; i++)
        {
            for(int j = 0; j < B.length; j++)
            {
                result += map.getOrDefault(-1*(A[i] + B[j]), 0);
            }
        }
        return result;
    }
}
