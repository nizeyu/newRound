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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode l, TreeNode r)
    {
        if(l == null && r == null)
            return true;
        else if(l != null && r != null)
        {
            if(l.val == r.val)
                return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
            else
                return false;
        }
        return false;
    }
}
