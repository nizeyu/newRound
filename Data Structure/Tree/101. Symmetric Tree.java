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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode l, TreeNode r) {
        if(l == null && r == null)
            return true;
        else if(l == null)
            return false;
        else if(r == null)
            return false;
        else {
            if(l.val != r.val)
                return false;
            else
                return helper(l.right, r.left) && helper(l.left, r.right);
        }
    }
}
