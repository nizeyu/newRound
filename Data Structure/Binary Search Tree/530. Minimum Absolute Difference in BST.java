//My Solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int min = Integer.MAX_VALUE;
    Integer pre = null;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        
        return min;
    }
    
    private void inorder(TreeNode node) {
        if(node == null)
            return;
            
        inorder(node.left);
        if(pre != null)
            min = Math.min(min, node.val - pre);
        pre = node.val;
        inorder(node.right);
    }
}
