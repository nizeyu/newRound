//Method 1: Heap
public class Solution
{
    public int kthSmallest(int[][] matrix, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                minHeap.offer(matrix[i][j]);
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++)
            min = minHeap.poll();
            
        return min;
    }
}

//Method 2: Binary Search
