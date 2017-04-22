public class Solution
{
    public class Cell
    {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height)
        {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    
    public int trapRainWater(int[][] heightMap)
    {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;
        
        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>(){
            public int compare(Cell a, Cell b)
            {
                return a.height - b.height;
            }
        });
        
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        
        // Initially, add all the Cells which are on borders to the queue.
        for(int i = 0; i < heightMap.length; i++)
        {
            visited[i][0] = true;
            visited[i][heightMap[0].length-1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, heightMap[0].length-1, heightMap[i][heightMap[0].length-1]));
        }
        
        for(int i = 0; i < heightMap[0].length; i++)
        {
            visited[0][i] = true;
            visited[heightMap.length-1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(heightMap.length-1, i, heightMap[heightMap.length-1][i]));
        }
        
        // from the borders, pick the shortest cell visited and check its neighbors:
        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
        // add all its neighbors to the queue
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while(!queue.isEmpty())
        {
            Cell cell = queue.poll();
            for(int[] dir : dirs)
            {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if(row >= 0 && row < heightMap.length && col >= 0 && col <heightMap[0].length && !visited[row][col])
                {
                    visited[row][col] = true;
                    res += Math.max(0, cell.height - heightMap[row][col]);
                    queue.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
                }
            }
        }
        return res;
    }
}
