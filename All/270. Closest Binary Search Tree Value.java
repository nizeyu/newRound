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
    double min = Double.MAX_VALUE;
    int value = Integer.MIN_VALUE;
    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        
        return value;
    }
    
    private void helper(TreeNode node, double target) {
        if(node == null)
            return;
        
        if(min > Math.abs(node.val - target)) {
            value = node.val;
            min = Math.min(min, Math.abs(node.val - target));
        }
        
        if(node.val == target)
            return;
        else if(node.val > target)
            helper(node.left, target);
        else
            helper(node.right, target);
    }
}
