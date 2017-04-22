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
    public int kthSmallest(TreeNode root, int k)
    {
        if(root == null || k <= 0)
            throw new IllegalArgumentException("Input is invalid");
        
        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        
        while(!stack.isEmpty() || p != null)
        {
            if(p != null)
            {
                stack.push(p);
                p = p.left;
            }
            else if(!stack.isEmpty())
            {
                TreeNode node = stack.pop();
                if(--k == 0)
                    return node.val;
                p = node.right;
            }
        }
        return result;
    }
}
