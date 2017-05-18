/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Divide & Conquer
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        if(getDepth(root) == -1)
            return false;
        
        return true;
    }
    
    private int getDepth(TreeNode node) {
        if(node == null)
            return 0;
        
        int l = getDepth(node.left);
        int r = getDepth(node.right);
        
        if(l == -1 || r == -1)
            return -1;
        
        if(Math.abs(l - r) > 1)
            return -1;
        
        return Math.max(l, r) + 1;
    }
}
