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
    public int maxPathSum(TreeNode root)
    {
        if(root == null)
            return Integer.MIN_VALUE;
        
        int [] max = new int [1];
        max[0] = Integer.MIN_VALUE;
        
        maxPathSum(root, max);
        
        return max[0];
    }
    
    private int maxPathSum(TreeNode node, int [] max)
    {
        if(node == null)
            return 0;
        
        int l = maxPathSum(node.left, max);
        int r = maxPathSum(node.right, max);
        
        int current = Math.max(node.val, Math.max(node.val + l, node.val + r));
        max[0] = Math.max(max[0], Math.max(current, l + node.val + r));
        
        return current;
    }
}
