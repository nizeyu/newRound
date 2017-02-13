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
    TreeNode cur;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root)
    {
        cur = null;
        first = null;
        second = null;
        
        inorderTraversal(root);
        
        if(first != null && second != null)
        {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
    
    private void inorderTraversal(TreeNode node)
    {
        if(node == null)
            return;
        
        inorderTraversal(node.left);
        
        if(cur == null)
            cur = node;
        else
        {
            if(cur.val > node.val)
            {
                if(first == null)
                    first = cur;
                second = node;
            }
            cur = node;
        }
        
        inorderTraversal(node.right);
    }
}
