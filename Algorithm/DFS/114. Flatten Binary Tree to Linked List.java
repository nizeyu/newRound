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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        
        while(p != null) {
            if(p.right != null)
                stack.push(p.right);
                
            if(p.left != null) {
                p.right = p.left;
                p.left = null;
            }
            else {
                if(!stack.isEmpty())
                    p.right = stack.pop();
            }
            p = p.right;
        }
    }
}
