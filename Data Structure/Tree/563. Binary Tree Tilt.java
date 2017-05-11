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
    int res = 0;
    public int findTilt(TreeNode root) {
        if(root == null)
            return res;
            
        tilt(root);
        
        return res;
    }
    
    private int tilt(TreeNode node) {
        if(node == null)
            return 0;
            
        int left = tilt(node.left);
        int right = tilt(node.right);
        res += Math.abs(left - right);
        
        return node.val + left + right;
    }
}
