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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int val = root.val;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            val = node.val;
            if(node.right != null)
                q.offer(node.right);
            if(node.left != null)
                q.offer(node.left);
        }
        return val;
    
