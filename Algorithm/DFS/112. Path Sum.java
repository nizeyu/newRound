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
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if(root == null)
            return false;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Integer> sumValue = new Stack<>();
        sumValue.push(root.val);
        
        while(!stack.isEmpty())
        {
            TreeNode node =  stack.pop();
            int val = sumValue.pop();
            
            if(node.left == null && node.right == null && val == sum)
                return true;
            
            if(node.right != null)
            {
                stack.push(node.right);
                sumValue.push(node.right.val + val);
            }
                
            if(node.left != null)
            {
                stack.push(node.left);
                sumValue.push(node.left.val + val);
            }
                
        }
        return false;
    }
}
