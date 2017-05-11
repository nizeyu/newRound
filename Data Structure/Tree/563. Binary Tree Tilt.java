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
            
        postOrder(root);
        
        return res;
    }
    
    private int postOrder(TreeNode node) {
        if(node == null)
            return 0;
            
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        res += Math.abs(left - right);
        
        return node.val + left + right;
    }
}
