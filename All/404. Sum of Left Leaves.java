//My Solution：DFS
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
    public int sumOfLeftLeaves(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            
            if(node.right != null)
            {
                if(node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
            
            if(node.left != null)
            {
                if(node.left.left == null && node.left.right == null )
                    sum += node.left.val;
                else
                    stack.push(node.left);
            }
        }
        return sum;
    }
}

//My Solution: Recursive
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
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        
        int sum = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null)
                sum += root.left.val;
            else 
                sum += sumOfLeftLeaves(root.left);
        }
        
        if(root.right != null) {
            if(root.right.left != null || root.right.right != null)
                sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }
}
