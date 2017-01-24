//Method 1: DFS
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public int pathSum(TreeNode root, int sum)
    {
        if(root == null)
            return 0;
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int findPath(TreeNode root, int sum)
    {
        int result = 0;
        if(root == null)
            return result;
        if(sum == root.val)
            result++;
        
        result += findPath(root.left, sum - root.val);
        result += findPath(root.right, sum - root.val);
        return result;
    }
}

//Method 2: Prefix sum method
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public int pathSum(TreeNode root, int sum)
    {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }
    private int helper(TreeNode root, int sum, int target, HashMap<Integer, Integer> preSum)
    {
        if(root == null)
            return 0;
        sum += root.val;
        int res = preSum.getOrDefault(sum - target, 0);
        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        
        res += helper(root.left, sum, target, preSum) + helper(root.right, sum, target, preSum);
        preSum.put(sum, preSum.get(sum) - 1);
        return res;
    }
}
